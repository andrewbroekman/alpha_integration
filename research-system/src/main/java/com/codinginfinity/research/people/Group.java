package com.codinginfinity.research.people;

/**
 * Created by andrew on 2016/04/11.
 */
public class Group extends Entity {

    private static final long serialVersionUID = 5829088373298508324L;

    private String name;



    private boolean active;

    public Group(String name) {
        this.name = name;
        this.active = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
