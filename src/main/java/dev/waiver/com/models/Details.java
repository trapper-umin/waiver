package dev.waiver.com.models;

import dev.waiver.com.models.common.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import java.time.LocalDateTime;

@Entity
@Table(name = "details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Details extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "details_id")
    private int id;

    @Column(name = "name")
    @Size(min = 3,max = 255, message = "name size should be between 3 and 255")
    private String name;

    @Column(name="age")
    @Min(value = 1,message = "minimal age value 1")
    @Max(value = 125,message = "maximum age value 125")
    private Integer age;

    @Column(name = "email")
    @Size(min = 3,max = 255, message = "email size should be between 3 and 255")
    @Email(message = "email incorrect")
    private String email;

    @Column(name = "points")
    private int points;

    @Column(name = "missed_tasks")
    private int missedTasks;

    @Column(name = "completed_tasks")
    private int completedTasks;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne()
    @JoinColumn(name = "person_id")
    private Person owner;

    public Details(String name,
                   Person owner,
                   int age,
                   String email,
                   int points,
                   int missedTasks,
                   int completedTasks,
                   LocalDateTime createdAt,
                   LocalDateTime updatedAt) {
        this.name = name;
        this.owner=owner;
        this.age = age;
        this.email = email;
        this.points = points;
        this.missedTasks = missedTasks;
        this.completedTasks = completedTasks;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Details(Person owner,
                   int points,
                   int missedTasks,
                   int completedTasks,
                   LocalDateTime createdAt,
                   LocalDateTime updatedAt) {
        this.owner = owner;
        this.points = points;
        this.missedTasks = missedTasks;
        this.completedTasks = completedTasks;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
