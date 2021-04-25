package tasks.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.collections.ArrayTaskList;

import static org.mockito.Mockito.mock;

class TasksServiceTestIntegrationOne {
    ArrayTaskList arrayTaskList;
    TasksService tasksService;

    @BeforeEach
    void setUp() {
        arrayTaskList = mock(ArrayTaskList.class);
        tasksService = new TasksService(arrayTaskList);
    }

    @Test
    void formTimeUnit() {
        assert (tasksService.formTimeUnit(30).equals("30"));
    }

    @Test
    void parseFromStringToSeconds() {
        assert (tasksService.parseFromStringToSeconds("00:02") == 120);
    }
}