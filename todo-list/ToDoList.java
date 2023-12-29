// importing ArrayList and Scanner
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks; // created an object of ArrayList of Strings

    public ToDoList() {     // constructor
        tasks = new ArrayList<>();
    }

    // method for adding a task
    public void addTask(String task){
        tasks.add(task);    // adding item to tasks(ArrayList<string>) using (.add) method
        System.out.println("Task added: " + task);
    }

    // method for removing a task
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {   // tasks.size() --> returns the number of elements in the list
            String removedTask =  tasks.remove(index);      // '.remove' method removes a particular index element from the list
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index, no task removed.");
        }
    }

    // method to display the To-Do List
    public void displayTasks() {
        if (tasks.isEmpty()){   // 'isEmpty' method returns true if list is empty else false
            System.out.println("No tasks added in the to-do list.");
        } else {
            System.out.println("To-Do list: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));      // '.get' method is used to get a particular element by index
            }
        }
    }

    // MAIN class
    public static void main (String[] args) {
        ToDoList list = new ToDoList();     // creating object of ToDoList named list
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add task\n2. Remove Task\n3.Display Tasks\n4. Exit");
            System.out.println("Enter your Choice: ");

            int choice;

            try {
                choice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input please enter a number.");
                scanner.nextLine();     // consume the invalid input entered
                continue;
            } scanner.nextLine();   // consumes the new line character '\n'

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String taskToAdd = scanner.nextLine();
                    list.addTask(taskToAdd);
                    break;
                
                case 2:
                    System.out.print("Enter index of task to remove: ");
                    int indexToRemove = scanner.nextInt();
                    list.removeTask(indexToRemove - 1);     // we subtracted -1, cause index starts from 0
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
}   // end of program