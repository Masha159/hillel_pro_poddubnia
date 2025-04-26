package org.lessons.lesson30.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@Embeddable
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDate deadline;
    private int mark;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return Objects.equals(id, homework.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", mark=" + mark +
                ", student=" + student +
                '}';
    }
}
