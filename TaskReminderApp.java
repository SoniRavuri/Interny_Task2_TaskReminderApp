import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private String category;
    private String dueDate;
    private boolean completed;
    private int priority;

    public Task(String title, String description, String category, String dueDate, int priority) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        String status = completed ? "Completed" : "Not Completed";
        return "Title: " + title + "\nDescription: " + description + "\nCategory: " + category + "\nDue Date: " + dueDate + "\nPriority: " + priority + "\nStatus: " + status;
    }
}

public class TaskReminderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Task Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Task Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Due Date (e.g., yyyy-mm-dd): ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Enter Priority (1-5): ");
                    int priority = scanner.nextInt();
                    tasks.add(new Task(title, description, category, dueDate, priority));
                    System.out.println("***Task added successfully.***");
                    break;
                case 2:
                    System.out.println("Tasks :");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        for (Task task : tasks) {
                            System.out.println(task);
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                        Task task = tasks.get(taskNumber - 1);
                        task.markAsCompleted();
                        System.out.println("Task marked as completed: " + task.getTitle());
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the Task Reminder Application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
