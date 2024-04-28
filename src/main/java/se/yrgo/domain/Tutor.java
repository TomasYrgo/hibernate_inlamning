package se.yrgo.domain;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @OneToMany
    @JoinColumn(name="TUTOR_FK")
    private Set<Student> teachingGroup;
    private String tutorid;
    private String name;
    private int salary;

    public Tutor() {
    }

    public Tutor(String tutorid, String name, int salary) {
        this.tutorid = tutorid;
        this.name = name;
        this.salary = salary;
        this.teachingGroup = new HashSet<Student>();
    }

    public void addStudentToTeachingGroup(Student newStudent){
        this.teachingGroup.add(newStudent);
    }

    public Set<Student> getTeachingGroup(){
        Set<Student> unmodifiable = Collections.unmodifiableSet(this.teachingGroup);
        return unmodifiable;
    }

    public String getTutorid() {
        return tutorid;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "tutorid='" + tutorid + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
