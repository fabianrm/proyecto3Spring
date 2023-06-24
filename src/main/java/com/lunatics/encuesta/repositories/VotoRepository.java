package com.lunatics.encuesta.repositories;

import com.lunatics.encuesta.models.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends CrudRepository<Voto, Long> {
}
