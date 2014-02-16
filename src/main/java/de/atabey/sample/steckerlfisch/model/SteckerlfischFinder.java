package de.atabey.sample.steckerlfisch.model;

import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Fuat Atabey
 */
public class SteckerlfischFinder {

    private final SteckerlfischStandRepository steckerlfischStandRepository;

    public SteckerlfischFinder(SteckerlfischStandRepository steckerlfischStandRepository) {
        Assert.notNull(steckerlfischStandRepository);
        this.steckerlfischStandRepository = steckerlfischStandRepository;
    }

    public List<Stand> findStaendeIn(String ort) {
        return steckerlfischStandRepository.findByOrt(ort);
    }
}
