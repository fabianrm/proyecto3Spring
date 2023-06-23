package com.lunatics.encuesta.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voto {

    @Id
    @GeneratedValue
    @Column(name = "VOTO_ID")
    private Long id;

    //Muchos votos pueden pertenecer a una opcion
    @ManyToOne
    @JoinColumn(name = "OPCION_ID")
    private Opcion opcion;

}
