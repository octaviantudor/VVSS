package tasks.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.model.collections.ArrayTaskList;

import java.util.ArrayList;
import java.util.Date;

public class TasksServiceWBT {

    private TasksService tasksService;


    @Test
    void  WBT_INVALID_01() {
        Task task = new Task("Task1", new Date(1000));
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task);
        tasksService = new TasksService(arrayTaskList);
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            tasksService.filterTasks(new Date(1000), new Date(900));
        });
    }


    @Test
    void  WBT_INVALID_02() {
        Task task = new Task("Task1", new Date(500));
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task);
        tasksService = new TasksService(arrayTaskList);
        Assertions.assertThrows(RuntimeException.class, ()->{
            tasksService.filterTasks(new Date(1000), new Date(2000));
        });
    }

    @Test
    void WBT_VALID_01() {
        Task task = new Task("Task1", new Date(1500));
        task.setActive(true);
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task);
        tasksService = new TasksService(arrayTaskList);

        try {
            ArrayList<Task> taskIterable = (ArrayList<Task>) tasksService.filterTasks(new Date(1000), new Date(2000));
            assert (taskIterable.size() == 1);
        }
        catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void WBT_VALID_02() {
        Task task = new Task("Task1", new Date(2000));
        task.setActive(true);
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task);
        tasksService = new TasksService(arrayTaskList);

        try {
            ArrayList<Task> taskIterable = (ArrayList<Task>) tasksService.filterTasks(new Date(1000), new Date(2000));
            assert (taskIterable.size() == 1);
        }
        catch (Exception e) {
            assert(false);
        }
    }

    @Test
    void WBT_VALID_03() {
        Task task1 = new Task("Task1", new Date(500));
        task1.setActive(true);
        Task task2 = new Task("Task1", new Date(2000));
        task2.setActive(true);
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        arrayTaskList.add(task1);
        arrayTaskList.add(task2);
        tasksService = new TasksService(arrayTaskList);

        try {
            ArrayList<Task> taskIterable = (ArrayList<Task>) tasksService.filterTasks(new Date(1000), new Date(2000));
            assert (taskIterable.size() == 1);
        }
        catch (Exception e) {
            assert(false);
        }
    }
}
