package org.mahanth;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {

    @Id
    private int lid;
    private String lname;

//    @ManyToOne
    @ManyToMany//(cascade = CascadeType.ALL)
    /*
    cascade = CascadeType.ALL ->
    When I do something to the parent entity, automatically apply the same operation to its child entities.
     */
    private List<Student> student = new ArrayList<>();

//    public Student getStudent() {
//        return student;
//    }

//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public Laptop() {

    }
    public Laptop(int lid, String lname) {
        this.lid = lid;
        this.lname = lname;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getLid() {
        return lid;
    }
    public String getLname() {
        return lname;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", lname='" + lname + '\'' +
                '}';
    }
}
