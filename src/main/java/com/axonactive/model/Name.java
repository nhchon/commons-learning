package com.axonactive.model;

/**
 * Created by nhchon on 3/17/2017 8:47 AM.
 */
public class Name {
    private String name;

    public Name(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "[" + name + "]";
    }
}
