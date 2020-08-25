package com.leif.knowme;

import com.leif.knowme.base.BaseContext;
import com.leif.knowme.exception.AppException;
import com.leif.knowme.po.*;
import com.leif.knowme.service.AccountService;
import com.leif.knowme.service.ScheduleService;
import com.leif.knowme.service.TodoService;
import com.leif.knowme.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
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

    @Test
    public void processTest() throws InterruptedException, AppException {
        String[] status = new String[]{TodoPo.STATUS_CREATE + ""};

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
        System.out.println(scheduleService.previewSchedule(context, new Date(),
                todoPos.stream().map(TodoPo::getTodoId).collect(Collectors.toList())));

        context.setAccountId(accountId);
        assert todoService.deleteByTodoId(context, todoId) == 1;
        assert todoService.getAccountAllTodos(accountId, status, 0).size() == 1;
        assert todoService.deleteAllByAccountId(accountId) == 2;
        assert todoService.getAccountAllTodos(accountId, status, 0).size() == 2;

    }


}
