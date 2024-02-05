package com.Task.Task.Model;

public class Task {
    public  int id;
    public String name;
    public  String firstName;

    public Task(int id, String name, String firstName) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
