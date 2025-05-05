package org.lessons.lesson30;

import org.lessons.lesson30.dao.GenericDao;
import org.lessons.lesson30.dao.StudentDaoImpl;
import org.lessons.lesson30.dto.Homework;
import org.lessons.lesson30.dto.Student;

import java.time.LocalDate;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        StudentDaoImpl dao = new StudentDaoImpl();
        Student student = new Student(10L, "John", "Glsk2s", "mamsmdk2",  new HashSet<>());

        dao.save(student);
        Student s = dao.findByEmail("mamsmdk2");

        s.setEmail("new@email.com");
        dao.deleteById(s.getId());
    }
}
