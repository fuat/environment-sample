package de.atabey.sample.steckerlfisch.model;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fuat Atabey
 */
public class SteckerlfischFinder {

    private final SteckerlfischStandRepository steckerlfischStandRepository;
    private final LiveService liveService;

    public SteckerlfischFinder(SteckerlfischStandRepository steckerlfischStandRepository, LiveService liveService) {
        Assert.notNull(steckerlfischStandRepository);
        Assert.notNull(liveService);
        this.liveService = liveService;
        this.steckerlfischStandRepository = steckerlfischStandRepository;
    }

    public List<Stand> findStaendeIn(final String ort, final int dayOfWeek) {
        List<Stand> result = new ArrayList<>();
        final List<Stand> staende = steckerlfischStandRepository.findByOrt(ort);
        for (Stand stand : staende) {
            if(liveService.isOpen(stand, dayOfWeek)) {
                result.add(stand);
            }
        }
        return result;
    }
}
