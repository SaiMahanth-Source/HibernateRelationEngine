package org.mahanth;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    private int rollno;
    private String name;
    private int marks;

//    @OneToMany//(cascade = CascadeType.ALL)
//    @OneToMany(mappedBy = "student")
    @ManyToMany(mappedBy = "student", fetch = FetchType.EAGER) // By default, fetch type will be lazy (fetch = FetchType.LAZY)
    private List<Laptop> laptop = new ArrayList<>();

    public int getRollno() {
        return rollno;
    }
    public String getName() {
        return name;
    }
    public int getMarks() {
        return marks;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
