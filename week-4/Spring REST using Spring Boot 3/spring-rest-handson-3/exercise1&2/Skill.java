package com.cognizant.springlearn.model;

public class Skill {
    private int id;
    private String name;

    // ✅ Add this getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // ✅ Add this getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Optional: toString()
    @Override
    public String toString() {
        return "Skill{id=" + id + ", name='" + name + "'}";
    }
}
