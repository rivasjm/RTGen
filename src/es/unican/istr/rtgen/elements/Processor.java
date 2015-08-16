package es.unican.istr.rtgen.elements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanm on 11/08/2015.
 */
public abstract class Processor {

    private Integer id;
    private String schedulingPolicy;
    private List<Task> tasks;


    public Processor(){
        tasks = new ArrayList<>();
    }

    public void addTask(Task aTask){
        tasks.add(aTask);
    }


    // Getter and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchedulingPolicy() {
        return schedulingPolicy;
    }

    public void setSchedulingPolicy(String schedulingPolicy) {
        this.schedulingPolicy = schedulingPolicy;
    }


    // Abstract methods

    public abstract void writeProcessor(File f);

}
