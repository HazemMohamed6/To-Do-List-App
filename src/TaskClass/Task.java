/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskClass;

/**
 *
 * @author METRO
 */
public class Task {
    private int id;
    private String title;
    private boolean isCompleted;
    
    public Task(int id , String title){
        this.id=id;
        this.title=title;
        this.isCompleted=false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean Completed) {
        this.isCompleted = Completed;
    }
    // بنحفظ 
    @Override
    public String toString(){
        return id + "," + title + "," + isCompleted;
    }
    // بنقرأ الملف
    public static Task fromString(String data){
        String[] parts=data.split(",");
        Task task = new Task(Integer.parseInt(parts[0]), parts[1]);
        task.setCompleted(Boolean.parseBoolean(parts[2]));
        return task;
    }
}
