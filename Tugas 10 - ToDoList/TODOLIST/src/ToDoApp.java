import model.*;
import util.TaskStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        tasks = TaskStorage.loadTasks();

        int choice;
        do {
            System.out.println("\n-- TO DO LIST --");
            System.out.println("1. Tambah Task");
            System.out.println("2. Lihat Task");
            System.out.println("3. Tandai Selesai");
            System.out.println("4. Edit Task");
            System.out.println("5. Hapus Task");
            System.out.println("6. Simpan & Keluar");
            System.out.print("Pilih: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> listTasks();
                case 3 -> markDone();
                case 4 -> editTask();
                case 5 -> deleteTask();
                case 6 -> TaskStorage.saveTasks(tasks);
                default -> System.out.println("Pilihan tidak valid.");
            }

        } while (choice != 6);
    }

    private static void addTask() {
        System.out.print("Judul task: ");
        String title = scanner.nextLine();
        System.out.print("Jenis task (1=Personal, 2=Work): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        Task task = null;
        if (type == 1) {
            System.out.print("Lokasi: ");
            String loc = scanner.nextLine();
            task = new PersonalTask(title, loc);
        } else if (type == 2) {
            System.out.print("Deadline: ");
            String deadline = scanner.nextLine();
            task = new WorkTask(title, deadline);
        }

        if (task != null) {
            tasks.add(task);
            System.out.println("Task berhasil ditambahkan.");
        }
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Belum ada task.");
            return;
        }
        int index = 1;
        for (Task task : tasks) {
            System.out.print(index++ + ". ");
            task.display();
        }
    }

    private static void markDone() {
        listTasks();
        System.out.print("Pilih nomor task yang selesai: ");
        int i = scanner.nextInt();
        if (i > 0 && i <= tasks.size()) {
            tasks.get(i - 1).markDone();
            System.out.println("Task ditandai selesai.");
        }
    }

    private static void editTask() {
        listTasks();
        System.out.print("Pilih nomor task yang ingin diedit judulnya: ");
        int i = scanner.nextInt();
        scanner.nextLine();
        if (i > 0 && i <= tasks.size()) {
            System.out.print("Judul baru: ");
            String newTitle = scanner.nextLine();
            tasks.get(i - 1).setTitle(newTitle);
            System.out.println("Judul diperbarui.");
        }
    }

    private static void deleteTask() {
        listTasks();
        System.out.print("Pilih nomor task yang ingin dihapus: ");
        int i = scanner.nextInt();
        if (i > 0 && i <= tasks.size()) {
            tasks.remove(i - 1);
            System.out.println("Task dihapus.");
        }
    }
}