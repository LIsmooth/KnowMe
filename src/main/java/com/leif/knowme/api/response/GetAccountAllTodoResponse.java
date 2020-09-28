package com.leif.knowme.api.response;

import com.leif.knowme.dto.TodoDto;

import java.util.List;

public class GetAccountAllTodoResponse {
    private List<TodoDto> todos;

    public GetAccountAllTodoResponse(List<TodoDto> todos) {
        this.todos = todos;
    }

    public List<TodoDto> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoDto> todos) {
        this.todos = todos;
    }
}
