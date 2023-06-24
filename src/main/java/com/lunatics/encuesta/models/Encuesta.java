package com.lunatics.encuesta.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Encuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue
    @Column(name = "ENCUESTA_ID")
    private Long id;

    @Column(name = "pregunta")
    private String pregunta;

    //Una encuesta puede tener muchas opciones
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENCUESTA_ID")
    @OrderBy
    private Set<Opcion> opciones;

}
