package com.lunatics.encuesta.repositories;

import com.lunatics.encuesta.models.Encuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRepository extends CrudRepository<Encuesta, Long> {
}
