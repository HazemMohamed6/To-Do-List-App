/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskManager;
import java.util.*;
import java.io.*;
import TaskClass.Task;
import CustomException.TaskNotFoundException;
/**
 *
 * @author METRO
 */
 public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private final String FILE_NAME = "tasks.txt";
    // قراءة و تحويل كل سطر الى تاسك  وتخزينهم فى ليست
    public void loadTasks(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = br.readLine()) != null){
            tasks.add(Task.fromString(line));
        }
        }catch(IOException e){
            System.out.println("No previos data found.");
        }
    }
    // فتح ملف لكتابة كل تاسك فى سطر وحفظ البينات
    public void saveTasks(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(Task t : tasks){
                bw.write(t.toString());
                bw.newLine();
            }
        }catch(IOException e )
        {
            System.out.println("Error saving data.");
        }
    }
    // منع تكرار الاى دى
    public void addTask(Task task){
        boolean exists = tasks.stream()
                .anyMatch(t -> t.getId() == task.getId());
        if (exists){
            System.out.println("❌ ID already exists!");
        }
        tasks.add(task);
        System.out.println("✅ Task added!");
    }
    
    public void showTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks available.");
            return;
        }
        tasks.forEach(t -> System.out.println(t.getId() + "-" + t.getTitle() +
                (t.isCompleted()? "✅" : "❌")));
    }
    //عرض التاسك غير المكتمل
    public void showPendingTasks(){
        tasks.stream()
                .filter(t -> !t.isCompleted())
                .forEach(t -> System.out.println(t.getTitle()));
    }
    
    // حذف تاسك
    public void deleteTask(int id) throws TaskNotFoundException {
        boolean removed = tasks.removeIf(t -> t.getId() == id);
        if(!removed){
            throw new TaskNotFoundException("❌ Task not found!");
        }
    }
    public void markCompleted(int id) throws TaskNotFoundException{
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("❌ Task not found!"));
        task.setCompleted(true);
    }
}
