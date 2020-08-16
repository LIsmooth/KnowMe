package com.leif.knowme;

import com.leif.knowme.model.TodoDo;
import com.leif.knowme.mapper.TodoMapper;
import com.leif.knowme.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KnowmeApplication.class)
public class KnowmeApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TodoMapper todoMapper;

    @Test
    public void getUserById(){
        System.out.println(userMapper.getUserById("1"));
    }

    @Test
    public void generateSchedule(){
        List<TodoDo> todoDos =todoMapper.generateSchedule("1");
        assert todoDos !=null;
        todoDos.forEach(t-> System.out.println(t.toString()));
    }

}
