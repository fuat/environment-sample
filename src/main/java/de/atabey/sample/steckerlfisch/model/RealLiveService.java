package de.atabey.sample.steckerlfisch.model;

import java.util.Random;

/**
 * @author Fuat Atabey
 */
public class RealLiveService implements LiveService {

    private final Random random;

    public RealLiveService() {
        this.random = new Random();
    }

    @Override
    public boolean isOpen(Stand stand, int dayOfWeek) {
        return (random.nextInt() + dayOfWeek) % 2 == 0;
    }
}
