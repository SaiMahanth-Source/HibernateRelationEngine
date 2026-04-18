package org.mahanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {

        Laptop laptop = new Laptop();
        laptop.setLid(11);
        laptop.setLname("Macbook");

//        List<Laptop> laptops = new ArrayList<Laptop>();
//        laptops.add(new Laptop(13, "Samusung"));
//        laptops.add(new Laptop(14, "Sony"));

        Student student = new Student();
        student.setRollno(1);
        student.setName("Sai Mahanth Nagendla");
        student.setMarks(91);
        student.getLaptop().add(laptop); // adding laptop objects manually
//        student.setLaptop(laptops); // Passing the list of added laptop objects directly
        laptop.getStudent().add(student);

        Configuration configuration = new Configuration().configure("config.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        // We have to add all the @Entity classes here

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(laptop);
        session.persist(student);

        transaction.commit();
        session.close();
    }
}
