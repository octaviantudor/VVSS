package tasks.model;

import javafx.collections.ObservableList;
import org.apache.log4j.Logger;
import tasks.model.collections.ArrayTaskList;

import java.util.*;

public class TasksOperations {

    public ArrayList<Task> tasks;
    private static final Logger log = Logger.getLogger(ArrayTaskList.class.getName());

    public TasksOperations(ObservableList<Task> tasksList){
        tasks=new ArrayList<>();
        tasks.addAll(tasksList);
    }

    public Iterable<Task> incoming(Date start, Date end){
        log.info("Start: " +start);
        log.info("End: " +end);
        ArrayList<Task> incomingTasks = new ArrayList<>();
        for (Task t : tasks) {
            Date nextTime = t.nextTimeAfter(start);
            if (nextTime != null && (nextTime.before(end) || nextTime.equals(end))) {
                incomingTasks.add(t);
                log.info(t.getTitle());
            }
        }
        return incomingTasks;
    }

}
