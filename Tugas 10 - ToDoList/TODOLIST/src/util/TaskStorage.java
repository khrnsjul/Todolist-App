package util;

import model.Task;

import java.io.*;
import java.util.ArrayList;

public class TaskStorage {
    private static final String FILE_NAME = "tasks.dat";

    public static void saveTasks(ArrayList<Task> tasks) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tasks = (ArrayList<Task>) ois.readObject();
        } catch (Exception e) {
            System.out.println("No saved tasks found or error loading: " + e.getMessage());
        }
        return tasks;
    }
}