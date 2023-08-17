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
    @Size(min = 1,max = 125,message = "age size should be between 1 and 125")
    private int age;

    @Column(name = "email")
    @Size(min = 3,max = 255, message = "email size should be between 3 and 255")
    @Email(message = "email incorrect")
    private String email;

    @Column(name = "points")
    @NotNull(message = "points should be not null")
    private int points;

    @Column(name = "missed_tasks")
    @NotNull(message = "missed tasks size should be not null")
    private int missedTasks;

    @Column(name = "completed_tasks")
    @NotNull(message = "completed tasks size should be not null")
    private int completedTasks;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
