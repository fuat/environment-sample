package de.atabey.sample.steckerlfisch.model;

import java.util.Calendar;

/**
 * @author Fuat Atabey
 */
public class MockLiveService implements LiveService {

    @Override
    public boolean isOpen(Stand stand, int dayOfWeek) {
        if(Calendar.SATURDAY == dayOfWeek) {
            return true;
        }
        return false;
    }
}
