package org.generation.springblogricette.repository;

import org.generation.springblogricette.model.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RicettaRepository extends JpaRepository<Ricetta, Integer> {
    List<Ricetta> findByTitoloContainingIgnoreCase(String titolo);
}
