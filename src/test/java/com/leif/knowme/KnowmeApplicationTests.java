package com.leif.knowme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.leif.knowme.api.response.ScheduleResponse;
import com.leif.knowme.base.BaseContext;
import com.leif.knowme.config.KmProperties;
import com.leif.knowme.dto.AccountDto;
import com.leif.knowme.dto.ScheduleDto;
import com.leif.knowme.dto.TodoDto;
import com.leif.knowme.dto.UserDto;
import com.leif.knowme.dto.mapper.ScheduleDtoMr;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.exception.AuthException;
import com.leif.knowme.service.AccountService;
import com.leif.knowme.service.ScheduleService;
import com.leif.knowme.service.TodoService;
import com.leif.knowme.service.UserService;
import com.leif.knowme.util.JwtUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KnowmeApplication.class)
public class KnowmeApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    TodoService todoService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    AccountService accountService;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    KmProperties kmProperties;


    @Before
    public void deleteTables() {
        String[] deletes = {
                "DELETE FROM t_user",
                "DELETE FROM t_todo",
                "DELETE FROM t_account",
                "DELETE FROM t_schedule",
                "DELETE FROM t_schedule_item"
        };
        Arrays.stream(deletes).forEach(s -> jdbcTemplate.execute(s));
    }

    @Test
    public void processTest() throws InterruptedException, AppException, JsonProcessingException {
        List<Integer> status = Collections.singletonList(TodoDto.STATUS_CREATE);

        UserDto userDto = new UserDto("Leif", new Date(), 0);
        String userId = userService.createUser(userDto);
        UserDto userDto2 = userService.getUserById(userId);
        assert userDto2.getName().equals(userDto.getName());

        String accountNo = "HelloLeif";
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountName("刘煜迪");
        accountDto.setAccountNo(accountNo);
        accountDto.setPassword("qwer1234");
        String accountId = accountService.createAccount(accountDto);
        assert accountService.checkIsAccountNoExist(accountNo);

        String eventMsg = "Test20";
        TodoDto todoDto = new TodoDto(accountId, 20, eventMsg, TodoDto.STATUS_CREATE);
        TodoDto todoDto2 = new TodoDto(accountId, 30, "eventMsg", TodoDto.STATUS_CREATE);
        String todoId = todoService.createTodo(todoDto);
        Thread.sleep(1000);
        String todoId2 = todoService.createTodo(todoDto2);

        List<TodoDto> todoDtos = todoService.getAccountAllTodos(accountId, status, 0);
        assert todoDtos.size() == 2;
        assert todoDtos.get(0).getEventMsg().equals(eventMsg);

        ScheduleDto dto = new ScheduleDto(accountId, "Test schedule", "this is note", new Date(), new Date(new Date().getTime() + 3000));
        assert scheduleService.createSchedule(dto, Arrays.asList(todoId, todoId2)) == 2;

        BaseContext context = new BaseContext();
        context.setAccountId(accountId);
        ScheduleDto scheduleDto = scheduleService.previewSchedule(context, new Date(),
                todoDtos.stream().map(TodoDto::getTodoId).collect(Collectors.toList()));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(scheduleDto);
        System.out.println(json);

        scheduleDto = scheduleService.getLatestSchedule(accountId);
        ScheduleResponse response = ScheduleDtoMr.INSTANCE.scheduleDto2ScheduleResponse(scheduleDto);
        json = ow.writeValueAsString(response);
        System.out.println(json);

        context.setAccountId(accountId);
        assert todoService.deleteByTodoId(context, todoId) == 1;
        List<TodoDto> accountAllTodos = todoService.getAccountAllTodos(accountId, status, 0);
        assert accountAllTodos.size() == 1;
        TodoDto dto1 = accountAllTodos.get(0);
        assert dto1.getType() == 0;
        assert todoService.deleteAllByAccountId(accountId) == 2;
        assert todoService.getAccountAllTodos(accountId, status, 0) == null;

    }

    @Test
    public void tokenTest() throws InterruptedException {
        String accountId = "HelloLeif";
        String token = jwtUtils.doGenerateToken(accountId,2).get("token").toString();
        System.out.println(token);
        String accountId2 = null;
        try {
            accountId2 = jwtUtils.getUsernameFromToken(token);
        } catch (AuthException e) {
            assert false;
        }
        assert accountId.equals(accountId2);
        Thread.sleep(3000L);
        try {
            accountId2 = jwtUtils.getUsernameFromToken(token);
        } catch (AuthException e) {
            assert e.getMessage().contains("token has expired");
        }
        System.out.println(accountId2);
    }

    @Test
    public void testConfig() {
        assert kmProperties.getWxAppId() != null;
        System.out.println(kmProperties.getWxAppId());
    }

    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        File configFile = new File("src\\main\\resources\\mybatis\\generator\\mybatis-generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }


}
