package com.lunatics.encuesta.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Opcion {
    @Id
    @GeneratedValue
    @Column(name = "OPCION_ID")
    private Long id;

    private String value;

}
