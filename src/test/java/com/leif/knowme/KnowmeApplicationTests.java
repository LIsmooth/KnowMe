package com.leif.knowme;

import com.leif.knowme.model.TodoDo;
import com.leif.knowme.mapper.TodoMapper;
import com.leif.knowme.mapper.UserMapper;
import com.leif.knowme.po.TodoPo;
import com.leif.knowme.po.UserPo;
import com.leif.knowme.service.TodoService;
import com.leif.knowme.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KnowmeApplication.class)
public class KnowmeApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    TodoService todoService;

    @Test
    public void processTest() {
        UserPo userPo = new UserPo("Leif", new Date(), 0);
        String userId = userService.createUser(userPo);
        UserPo userPo2 = userService.getUserById(userId);
        assert userPo2.getName().equals(userPo.getName());

        String eventMsg = "Test20";
        TodoPo todoPo = new TodoPo(userId, 20, eventMsg, TodoPo.STATUS_CREATE);
        TodoPo todoPo2 = new TodoPo(userId, 30, "eventMsg", TodoPo.STATUS_CREATE);
        String todoId = todoService.createTodo(todoPo);
        todoService.createTodo(todoPo2);

        List<TodoPo> todoPos = todoService.getUserAllTodos(userId, TodoPo.STATUS_CREATE, 0);
        assert todoPos.size() == 2;
        assert todoPos.get(0).getEventMsg().equals(eventMsg);
        assert todoService.deleteByTodoId(todoId) == 1;
        assert todoService.getUserAllTodos(userId, TodoPo.STATUS_CREATE, 0).size() == 1;
        assert todoService.deleteAllByUserId(userId) == 1;
        assert todoService.getUserAllTodos(userId, TodoPo.STATUS_CREATE, 0).size() == 0;
    }


}
