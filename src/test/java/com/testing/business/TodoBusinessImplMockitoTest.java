package com.testing.business;

import com.testing.data.api.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockitoTest {

    @Test
    public void test_usingMockito() {
        //Given
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        //When
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");

        //Then
        assertEquals(2, todos.size());
    }

    @Test
    public void testEmptyList_usingMockito() {
        //Given
        TodoService todoService = mock(TodoService.class);
        List<String> allTodos = Arrays.asList();
        when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);

        //When
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");

        //Then
        assertEquals(2, todos.size());
    }
}