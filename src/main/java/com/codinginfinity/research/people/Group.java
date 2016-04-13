package com.codinginfinity.research.people;

/**
 * Created by andrew on 2016/04/11.
 */
public class Group extends Entity {

    private static final long serialVersionUID = 5829088373298508324L;

    private String name;

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
