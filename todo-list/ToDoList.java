import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task){
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask =  tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index, no task removed.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()){
            System.out.println("No tasks added in the to-do list.");
        } else {
            System.out.println("To-Do list: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main (String[] args) {
        ToDoList list = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add task\n2. Remove Task\n3.Display Tasks\n4. Exit");
            System.out.println("Enter your Choice: ");

            int choice;

            try {
                choice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input please enter a number.");
                scanner.nextLine();
                continue;
            } scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    list.addTask(taskToAdd);
                    break;
                
                case 2:
                    System.out.print("Enter index of task to remove: ");
                    int indexToRemove = scanner.nextInt();
                    list.removeTask(indexToRemove - 1);
                    break;

                case 3:
                    System.out.println("-----------------------------");
                    list.displayTasks();
                    System.out.println("-----------------------------");
                    break;

                case 4:
                    System.out.println("Exiting the list. Thanks for using our services!!");
                    scanner.close();
                    System.exit(0);
                    break;

                default: 
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }
    }
}