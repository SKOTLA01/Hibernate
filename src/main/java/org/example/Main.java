package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Student s1=new Student();
        s1.setsAge(24);
        s1.setsName("Saiteja");
        s1.setRollNo(107);

        Configuration configuration=new Configuration();
configuration.addAnnotatedClass(Student.class);

        configuration.configure();

        Session session;
        try (SessionFactory sf = configuration.buildSessionFactory()) {

            session = sf.openSession();
        }
        Transaction transaction=session.beginTransaction();

        session.persist(s1);
    transaction.commit();
        System.out.println(s1);


    }
}