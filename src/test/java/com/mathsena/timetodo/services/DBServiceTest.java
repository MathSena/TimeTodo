package com.mathsena.timetodo.services;

import com.mathsena.timetodo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
class DBServiceTest {
    @Mock
    TodoRepository todoRepository;
    @InjectMocks
    DBService dBService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should instace the DataBase")
    void testInstanceDataBase(){
        dBService.instanceDataBase();
        verify(todoRepository, times(1)).saveAll(anyList());
    }
}
