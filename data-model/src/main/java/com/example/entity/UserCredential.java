package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collage_user")
@SequenceGenerator(name = "sequence_generator_name", sequenceName = "generate_by_one", allocationSize = 1)
public class UserCredential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence_generator_name")
    private Integer id;
    private String name;
    private String email;
    private String password;
}
