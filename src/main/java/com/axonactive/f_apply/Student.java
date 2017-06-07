package com.axonactive.f_apply;

import java.util.function.Function;

/**
 * Created by nhchon on 3/8/2017 5:12 PM.
 */
public class Student {
    public String name;
    public int age;
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public  String customShow(Function<Student,String> fun){
        return fun.apply(this);
    }
}
