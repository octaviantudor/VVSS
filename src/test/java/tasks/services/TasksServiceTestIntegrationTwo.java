package tasks.services;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.Task;
import tasks.model.collections.ArrayTaskList;

import static org.mockito.Mockito.mock;

class TasksServiceTestIntegrationTwo {

    ArrayTaskList arrayTaskList;

    TasksService tasksService;


    @BeforeEach
    void setUp() {
        arrayTaskList = new ArrayTaskList();
        tasksService = new TasksService(arrayTaskList);
    }

    @Test
    void getObservableList() {
        // arrange
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);
        Task task3 = mock(Task.class);
        Mockito.when(task1.getTitle()).thenReturn("Titlu1");

        // act
        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        arrayTaskList.add(task3);
        ObservableList<Task> observableList = tasksService.getObservableList();

        // assert
        assert(observableList.size() == 3);
        assert(observableList.get(0).getTitle().equals("Titlu1"));
    }

    @Test
    void getTaskListSize() {
        // arrange
        Task task1 = mock(Task.class);
        Task task2 = mock(Task.class);
        Task task3 = mock(Task.class);

        // act
        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        arrayTaskList.add(task3);

        // assert
        assert(tasksService.getObservableList().size() == 3);
    }
}