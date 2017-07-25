package org.chonnguyen.learning.model;

/**
 * Created by nhchon on 6/7/2017 9:26 AM.
 */
public class State {
    private String code;
    private String name;

    public State(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
