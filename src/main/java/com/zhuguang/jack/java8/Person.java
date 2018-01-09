package com.zhuguang.jack.java8;

public class Person implements Comparable<Person> {
    
    String name;
    
    public String getName() {
        return name;
    }
    
    public Person(String name) {
        this.name = name;
    }
    
    public Person() {
        
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
    
    @Override
    public int compareTo(Person paramT) {
        return paramT.getName().compareTo(this.getName());
    }
}
