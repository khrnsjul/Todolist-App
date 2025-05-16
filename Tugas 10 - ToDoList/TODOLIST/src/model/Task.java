package model;

import java.io.Serializable;

public abstract class Task implements Serializable {
    protected String title;
    protected boolean isDone;

    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    public void markDone() {
        isDone = true;
    }

    public void markUndone() {
        isDone = false;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void display();
}
