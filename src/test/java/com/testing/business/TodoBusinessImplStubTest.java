package com.testing.business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.testing.data.api.TodoService;
import com.testing.data.stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

    @Test
    public void usingAStub() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }
}