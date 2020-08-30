package com.leif.knowme;

import com.leif.knowme.base.BaseContext;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.po.AccountPo;
import com.leif.knowme.po.SchedulePo;
import com.leif.knowme.po.TodoPo;
import com.leif.knowme.po.UserPo;
import com.leif.knowme.service.AccountService;
import com.leif.knowme.service.ScheduleService;
import com.leif.knowme.service.TodoService;
import com.leif.knowme.service.UserService;
import org.apache.ibatis.session.SqlSession;
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
import java.util.*;
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


    @Before
    public void deleteTables()
    {
        jdbcTemplate.execute("delete from t_account");
    }

    @Test
    public void processTest() throws InterruptedException, AppException {
        List<Integer> status = Collections.singletonList(TodoPo.STATUS_CREATE);

        UserPo userPo = new UserPo("Leif", new Date(), 0);
        String userId = userService.createUser(userPo);
        UserPo userPo2 = userService.getUserById(userId);
        assert userPo2.getName().equals(userPo.getName());

        String accountNo = "HelloLeif";
        AccountPo accountPo = new AccountPo();
        accountPo.setAccountName("刘煜迪");
        accountPo.setAccountNo(accountNo);
        accountPo.setPassword("qwer1234");
        String accountId = accountService.createAccount(accountPo);
        assert accountService.checkIsAccountNoExist(accountNo);

        String eventMsg = "Test20";
        TodoPo todoPo = new TodoPo(accountId, 20, eventMsg, TodoPo.STATUS_CREATE);
        TodoPo todoPo2 = new TodoPo(accountId, 30, "eventMsg", TodoPo.STATUS_CREATE);
        String todoId = todoService.createTodo(todoPo);
        Thread.sleep(1000);
        String todoId2 = todoService.createTodo(todoPo2);

        List<TodoPo> todoPos = todoService.getAccountAllTodos(accountId, status, 0);
        assert todoPos.size() == 2;
        assert todoPos.get(0).getEventMsg().equals(eventMsg);

        BaseContext context = new BaseContext();
        context.setAccountId(accountId);
        SchedulePo schedulePo=scheduleService.previewSchedule(context, new Date(),
                todoPos.stream().map(TodoPo::getTodoId).collect(Collectors.toList()));
        System.out.println(schedulePo);

        context.setAccountId(accountId);
        assert todoService.deleteByTodoId(context, todoId) == 1;
        assert todoService.getAccountAllTodos(accountId, status, 0).size() == 1;
        assert todoService.deleteAllByAccountId(accountId) == 2;
        assert todoService.getAccountAllTodos(accountId, status, 0)==null;

    }


/*    public static void main(String[] args) throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        File configFile = new File("src\\main\\resources\\mybatis\\generator\\mybatis-generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, 		warnings);
        myBatisGenerator.generate(null);
    }*/



}
