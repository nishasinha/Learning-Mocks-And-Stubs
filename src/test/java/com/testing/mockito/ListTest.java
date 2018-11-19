package com.testing.mockito;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ListTest{

    @Test
    public void test_listSize(){
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2).thenReturn(3).thenReturn(3);

        assertEquals(2, mockList.size());
        assertEquals(3, mockList.size());
        assertEquals(3, mockList.size());
    }

    @Test
    public void test_niceMock() {
        List mockList = mock(List.class);
        assertEquals(0, mockList.size());
        assertEquals(null, mockList.get(anyInt()));
    }

    @Test
    public void test_listGet() {
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("one");

        assertEquals("one", mockList.get(0));
    }

    @Test
    public void test_argumentMatchers() {
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn("anyInt");

        assertEquals("anyInt", mockList.get(0));
        assertEquals("anyInt", mockList.get(1));
        assertEquals("anyInt", mockList.get(2));
    }
}
