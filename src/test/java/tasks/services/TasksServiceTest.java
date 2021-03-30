package tasks.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.model.TaskValidator;
import tasks.model.collections.ArrayTaskList;
import tasks.model.collections.TaskList;
import tasks.repository.TasksFileRepository;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class TasksServiceTest {
    private ArrayTaskList tasksECP;
    private ArrayTaskList tasksBVA;
    private TasksService tasksService;
    private File file = new File("C:\\Users\\ACER\\Desktop\\VVSS\\Proiecte\\01_Tasks\\src\\test\\java\\resources\\test.txt");





    @BeforeEach
    void setUp() {
        tasksECP = new ArrayTaskList();
        tasksBVA = new ArrayTaskList();
        tasksService = new TasksService(new ArrayTaskList(), new TaskValidator());
        try {
            String string1 = "2010-2-10 10:00";
            String string2 = "2010-2-12 10:00";
            String string3 = "2010-3-10 10:00";
            String string4 = "2010-3-14 10:00";
            String string5 = "2010-4-15 10:00";
            String string6 = "2010-4-19 10:00";

            DateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm", Locale.ENGLISH);
            Date date1 = format.parse(string1);
            Date date2 = format.parse(string2);
            Date date3 = format.parse(string3);
            Date date4 = format.parse(string4);
            Date date5 = format.parse(string5);
            Date date6 = format.parse(string6);


            System.out.println(date1);


            Task t1 = new Task("Task1", date1, date2, -5); //invalid
            Task t2 = new Task("Task2", date3, date4, 20); // valid
            Task t3 = new Task("Task3", date5, date6, 69); // invalid

            Task t4 = new Task("Task4", date1, date2, 0); //invalid
            Task t5 = new Task("Task5", date3, date4, 1); // valid
            Task t6 = new Task("Task6", date5, date6, 2); // invalid
            Task t7 = new Task("Task7", date1, date2, 47); //invalid
            Task t8 = new Task("Task8", date3, date4, 48); // valid
            Task t9 = new Task("Task9", date5, date6, 61); // invalid

            tasksBVA.add(t4);
            tasksBVA.add(t5);
            tasksBVA.add(t6);
            tasksBVA.add(t7);
            tasksBVA.add(t8);
            tasksBVA.add(t9);

            tasksECP.add(t1);
            tasksECP.add(t2);
            tasksECP.add(t3);

        }catch (ParseException pe){
            System.out.println(pe.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        try(OutputStream out = new FileOutputStream(file)){
            out.flush();
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

    }

    @Test
    void addTaskECP1() {
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            tasksService.addTask(tasksECP.getTask(0),file);
            assert false;
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        catch (IllegalArgumentException iae){
            assert true;
        }
    }

    @Test
    void addTaskECP2() {
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            tasksService.addTask(tasksECP.getTask(1),file);
            TaskList tasksFromFile = new ArrayTaskList();
            TasksFileRepository.read(tasksFromFile,in);
            assertEquals(tasksFromFile.size(), 1);
            assertEquals(tasksECP.getTask(1), tasksFromFile.getTask(0));
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }


    @Test
    void addTaskECP3() {
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            tasksService.addTask(tasksECP.getTask(2),file);
            assert false;
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        catch (IllegalArgumentException iae){
            assert true;
        }
    }

    @Test
    void addTaskBVA1() {
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            tasksService.addTask(tasksBVA.getTask(0),file);
            assert false;
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        catch (IllegalArgumentException iae){
            assert true;
        }
    }

    @Test
    void addTaskBVA2() {
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            tasksService.addTask(tasksBVA.getTask(1),file);
            TaskList tasksFromFile = new ArrayTaskList();
            TasksFileRepository.read(tasksFromFile,in);
            assertEquals(tasksFromFile.size(), 1);
            assertEquals(tasksBVA.getTask(1), tasksFromFile.getTask(0));
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }


    @Test
    void addTaskBVA3() {
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            tasksService.addTask(tasksBVA.getTask(2),file);
            TaskList tasksFromFile = new ArrayTaskList();
            TasksFileRepository.read(tasksFromFile,in);
            assertEquals(tasksFromFile.size(), 1);
            assertEquals(tasksBVA.getTask(2), tasksFromFile.getTask(0));
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    @Test
    void addTaskBVA4() {
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            tasksService.addTask(tasksBVA.getTask(3),file);
            TaskList tasksFromFile = new ArrayTaskList();
            TasksFileRepository.read(tasksFromFile,in);
            assertEquals(tasksFromFile.size(), 1);
            assertEquals(tasksBVA.getTask(3), tasksFromFile.getTask(0));
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    @Test
    void addTaskBVA5() {
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            tasksService.addTask(tasksBVA.getTask(4),file);
            TaskList tasksFromFile = new ArrayTaskList();
            TasksFileRepository.read(tasksFromFile,in);
            assertEquals(tasksFromFile.size(), 1);
            assertEquals(tasksBVA.getTask(4), tasksFromFile.getTask(0));
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }


    @Test
    void addTaskBVA6() {
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            tasksService.addTask(tasksBVA.getTask(5),file);
            assert false;
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
        catch (IllegalArgumentException iae){
            assert true;
        }
    }
}