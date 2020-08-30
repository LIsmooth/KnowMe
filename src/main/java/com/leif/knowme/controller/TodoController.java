package com.leif.knowme.controller;

import com.leif.knowme.api.request.CreateTodoRequest;
import com.leif.knowme.base.BaseContext;
import com.leif.knowme.base.KmRequest;
import com.leif.knowme.exception.AuthException;
import com.leif.knowme.dto.TodoDto;
import com.leif.knowme.service.TodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/todos")
public class TodoController extends BaseController {

    @Autowired
    TodoService todoService;

    @PostMapping(headers = "Accept=application/json")
    public String createTodo(@RequestBody KmRequest<CreateTodoRequest> request) {
        TodoDto todoDto=new TodoDto();
        BeanUtils.copyProperties(request.getData(), todoDto);
        return todoService.createTodo(todoDto);
    }

    @DeleteMapping("/{todoId}")
    public int deleteByTodoId(@RequestBody KmRequest<Object> request, @PathVariable String todoId) {
        return todoService.deleteByTodoId(new BaseContext(request), todoId);
    }

    @DeleteMapping("/account/{accountId}")
    public int deleteAllByAccountId(@RequestBody KmRequest<Object> request, @PathVariable String accountId) throws
            AuthException {
        checkRequest(request, accountId);
        return todoService.deleteAllByAccountId(accountId);
    }

    @PutMapping
    public int updateTodo(@RequestBody TodoDto todoDto) {
        return 0;//TODO updateTodo
    }

    @GetMapping("/account/{accountId}/status/{status}/{pageNo}")
    public List<TodoDto> getAccountAllTodos(@RequestBody KmRequest<Object> request, @PathVariable String accountId,
                                            @PathVariable String status,
                                            @PathVariable int pageNo) throws AuthException {
        checkRequest(request, accountId);
        return todoService
                .getAccountAllTodos(accountId,
                        Arrays.stream(status.split("-")).mapToInt(Integer::valueOf).boxed().collect(
                                Collectors.toList()),
                        pageNo);
    }

/*

    @GetMapping(value = "/showschedule/{userId}/{beginTime}")
    public String showSchedule(@PathVariable String userId,
                               @PathVariable @DateTimeFormat(pattern = "yyyyMMddHHmm") Date beginTime)
            throws AppException {
        return todoService.showSchedule(userId, beginTime);
    }
*/

}
