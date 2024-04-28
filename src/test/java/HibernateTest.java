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


        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();


        Tutor newTutor = new Tutor("ABC234", "Natalie Woodward", 387787);
        Student student1 = new Student("Patrik Howard");
        Student student2 = new Student("Marie Sani");
        Student student3 = new Student("Tom Nikson");

        newTutor.addStudentToTeachingGroup(student1);
        newTutor.addStudentToTeachingGroup(student2);
        newTutor.addStudentToTeachingGroup(student3);



        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(newTutor);

        //List<Student>students = newTutor.getTeachingGroup();
        //for(Student student: students) {
        //    System.out.println(student);
        //}

        Tutor myTutor = session.get(Tutor.class, 44);
        List<Student>students = myTutor.getTeachingGroup();
        for(Student s: students) {
            System.out.println(s);
        }

        tx.commit();
        session.close();
    }
}
