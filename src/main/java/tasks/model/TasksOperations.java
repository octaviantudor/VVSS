package tasks.model;

import javafx.collections.ObservableList;
import org.apache.log4j.Logger;
import tasks.model.collections.ArrayTaskList;

import java.util.*;

public class TasksOperations {

    public ArrayList<Task> tasks;

    public TasksOperations(ObservableList<Task> tasksList){
        tasks=new ArrayList<>();
        tasks.addAll(tasksList);
    }

    public Iterable<Task> incoming(Date start, Date end) throws RuntimeException{

        ArrayList<Task> incomingTasks = new ArrayList<>();

        if(end.before(start))
            throw new IllegalArgumentException("End date before start date");
        for (Task t : tasks) {

            Date nextTime = t.nextTimeAfter(start);
            if (nextTime != null && (nextTime.before(end) || nextTime.equals(end))) {
                incomingTasks.add(t);
            }
        }

        if(incomingTasks.isEmpty())
            throw new RuntimeException("No results");

        return incomingTasks;
    }

}

