package dev.waiver.com.models;

import dev.waiver.com.common.Role;
import dev.waiver.com.models.common.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends AbstractEntity {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "username")
    @NotBlank(message = "username should be not blank")
    @Size(min = 4, max = 254, message = "username size should be between 4 and 254")
    //UNIQUE
    private String username;

    @Column(name = "password")
    @NotBlank(message = "password should be not blank")
    @Size(min = 4, max = 254, message = "password size should be between 4 and 254")
    private String password;


    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;
}