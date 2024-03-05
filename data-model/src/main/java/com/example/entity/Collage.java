package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collage")
public class Collage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="student_id")
    private Integer studentId;

    @Column(name="student_stream")
    private String studentStream;

    @Column(name="collage_name")
    private String collageName;

    @Column(name="collage_address")
    private String collageAddress;

}
