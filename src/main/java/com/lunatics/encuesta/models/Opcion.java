package com.lunatics.encuesta.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opcion {
    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPCION_ID")
    private Long id;

    private String value;

}
