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
        Student student = new Student(1L, "John", "Glsk2s", "mamsmdk2",  new HashSet<>());
        Student student1 = new Student(2L, "John1", "Glsks3", "mamsmdk3",  new HashSet<>());
        Student student2 = new Student(3L, "John2", "Glsks4", "mamsmdk4",  new HashSet<>());
        Student student3 = new Student(4L, "John3", "Glsks5", "mamsmdk5",  new HashSet<>());
        Student student4 = new Student(4L, "John3", "Glsks5", "mamsmdk5", new HashSet<>());
        Homework homework = new Homework();
        homework.setDeadline(LocalDate.now().plusDays(1));
        homework.setDescription("description");
        homework.setMark(4);
        student4.addHomework(homework);

        dao.save(student);
        dao.save(student1);
        dao.save(student2);
        dao.save(student3);
        dao.save(student4);
    }
}
