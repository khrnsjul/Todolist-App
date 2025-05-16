package model;

public class PersonalTask extends Task {
    private String location;

    public PersonalTask(String title, String location) {
        super(title);
        this.location = location;
    }

    @Override
    public void display() {
        System.out.println("[Personal] " + title + " @ " + location + " - " + (isDone ? "DONE" : "NOT DONE"));
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
