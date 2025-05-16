package model;

public class WorkTask extends Task {
    private String deadline;

    public WorkTask(String title, String deadline) {
        super(title);
        this.deadline = deadline;
    }

    @Override
    public void display() {
        System.out.println("[Work] " + title + " | Deadline: " + deadline + " - " + (isDone ? "DONE" : "NOT DONE"));
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
            this.deadline = deadline;
        }
}