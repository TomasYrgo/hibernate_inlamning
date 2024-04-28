import org.hibernate.*;
import org.hibernate.cfg.*;
import se.yrgo.domain.*;

import java.util.*;

public class HibernateTest {

    private static SessionFactory sessionFactory = null;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
        // Student newStudent = new Student("Nick Fame", "Diamond Cameron");
        // System.out.println(newStudent);

        // Student nr1 = new Student("Tomas", "T-man");
        // Student nr2 = new Student("Sven", "Banan");

        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // session.save(newStudent);
        // session.save(nr1);
        // session.save(nr2);

        // Student myStudent = (Student) session.get(Student.class, 2);
        // session.delete(myStudent);

        // Student anotherStudent = (Student) session.get(Student.class, 3);
        // anotherStudent.setTutorName("David Graveyard");

        //Student newStudent = new Student("Ada Svensson");
        //session.save(newStudent);

        //Tutor tutor = new Tutor("ABC123" ,"Edward", 30000);
        //Student student = new Student("Sara Hedborn");
        //student.allocateTutor(tutor);
        //System.out.println(student.getTutorName());

        Tutor newTutor = new Tutor("ABC234", "Natalie Woodward", 387787);
        Student student1 = new Student("Patrik Howard");
        Student student2 = new Student("Marie Sani");
        Student student3 = new Student("Tom Nikson");

        newTutor.addStudentToTeachingGroup(student1);
        newTutor.addStudentToTeachingGroup(student2);
        newTutor.addStudentToTeachingGroup(student3);

        Set<Student>students = newTutor.getTeachingGroup();
        for(Student student: students) {
            System.out.println(student);
        }

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(newTutor);

       // Tutor myTutor = session.get(Tutor.class, 30);
        // Set<Student>students = myTutor.getTeachingGroup();
        //for(Student s: students) {
          //  System.out.println(s);
        //}

        //Student student4 = new Student("Julia Ericcson");
        //session.save(student4);
        //myTutor.addStudentToTeachingGroup(student4);


        //session.save(student);
        //session.save(tutor);

        tx.commit();
        session.close();

        // System.out.println("The student has an id  of: " + nr1.getId());
        // System.out.println(myStudent + " is the student");

    }
}
