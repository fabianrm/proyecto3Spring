package com.lunatics.encuesta.repositories;

import com.lunatics.encuesta.models.Opcion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionRepository extends CrudRepository<Opcion, Long> {
}
