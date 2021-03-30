package tasks.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.model.Task;
import tasks.model.collections.ArrayTaskList;
import tasks.model.collections.TaskList;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class TasksFileRepositoryTest {
    private TaskList tasks;

    @BeforeEach
    void setUp() {
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
            Task t1 = new Task("Task1", date1, date2, 1);
            Task t2 = new Task("Task2", date3, date4, 2);
            Task t3 = new Task("Task3", date5, date6, 3);

            tasks = new ArrayTaskList();

            tasks.add(t1);
            tasks.add(t2);
            tasks.add(t3);

        }catch (ParseException pe){
            System.out.println(pe.getMessage());
        }
    }

    @AfterEach
    void tearDown() throws IOException {
        try(OutputStream out = new FileOutputStream
                (new File("C:\\Users\\ACER\\Desktop\\VVSS\\Proiecte\\01_Tasks\\src\\test\\java\\resources\\test.txt"))){
            out.flush();
        }
    }

    @Test
    void write() {
        File file = new File("C:\\Users\\ACER\\Desktop\\VVSS\\Proiecte\\01_Tasks\\src\\test\\java\\resources\\test.txt");
        try(OutputStream out = new FileOutputStream(file);
            InputStream in = new FileInputStream(file)){
            TasksFileRepository.write(tasks,out);
            TaskList tasksFromFile = new ArrayTaskList();
            TasksFileRepository.read(tasksFromFile,in);
            assertEquals(tasksFromFile.size(), tasks.size());
            for(int i = 0; i < tasksFromFile.size(); i++){
                assertEquals(tasks.getTask(i), tasksFromFile.getTask(i));
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

}