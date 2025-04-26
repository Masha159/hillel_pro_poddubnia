package org.lessons.lesson30.dao;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.lessons.lesson30.dto.Student;

import java.util.List;

public class StudentDaoImpl implements GenericDao<Student, Long>{
    static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory();
    static Session session = sessionFactory.openSession();
    @Override
    public void save(Student entity) {
        session.beginTransaction();
        if (entity.getId() == null) {
            session.persist(entity);
        } else {
            session.merge(entity);
        }
        session.getTransaction().commit();
    }

    @Override
    public Student findById(Long aLong) {
        Student student;
        student = session.find(Student.class, aLong);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        TypedQuery<Student> student = session.createQuery("SELECT s FROM Student s WHERE s.email = :email", Student.class);
        student.setParameter("email", email);
        return student.getSingleResult();
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = session.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        return students;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }
}
