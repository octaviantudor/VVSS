package tasks.model;

public class TaskValidator {
    public boolean validate(Task task){
        if (task.getStartTime().getTime() < 0 || task.getEndTime().getTime() < 0) {
            return false;
        }
        if(task.getTitle().length() < 5 || task.getTitle().length() > 40)
            return false;
        return task.getRepeatInterval() >= 1 && task.getRepeatInterval() <= 60;
    }
}
