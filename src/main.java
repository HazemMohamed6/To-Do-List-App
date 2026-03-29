/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.*;
import TaskClass.Task;
import TaskManager.TaskManager;
import CustomException.TaskNotFoundException;
/**
 *
 * @author METRO
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TaskManager manager = new TaskManager();
        manager.loadTasks();
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("\n1- Add Task");
            System.out.println("2- Show Tasks");
            System.out.println("3- Show Pending");
            System.out.println("4- Delete Task");
            System.out.println("5- Mark Completed");
            System.out.println("6- Exit");
            try{
                int choice = sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Enter ID: ");
                        int id=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Title: ");
                        String title=sc.nextLine();
                        manager.addTask(new Task(id,title));
                        break;
                    case 2:
                        manager.showTasks();
                        break;
                    case 3:
                        manager.showPendingTasks();
                        break;
                    case 4:
                        System.out.println("Enter ID: ");
                        manager.deleteTask(sc.nextInt());
                        break;
                    case 5:
                        System.out.println("Enter ID: ");
                        manager.markCompleted(sc.nextInt());
                        break;
                    case 6:
                        manager.saveTasks();
                        System.exit(0);
                        break;
                }
            }catch(TaskNotFoundException e){
                System.out.println(e.getMessage());
            }catch(Exception e){
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }
    
}
