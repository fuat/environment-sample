package de.atabey.sample.steckerlfisch.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Fuat Atabey
 */
public interface SteckerlfischStandRepository extends CrudRepository<Stand, Long> {

    List<Stand> findByOrt(String ort);
}
