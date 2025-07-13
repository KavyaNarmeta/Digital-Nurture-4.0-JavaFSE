package com.cognizant.springlearn.model;

public class Department {
    private int id;
    private String name;

    // ✅ Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // ✅ Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ✅ Optional: for logging/debugging
    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "'}";
    }
}
