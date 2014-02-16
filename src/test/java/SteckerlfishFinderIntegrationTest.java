import de.atabey.sample.steckerlfisch.model.Stand;
import de.atabey.sample.steckerlfisch.model.SteckerlfischFinder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Fuat Atabey
 */
@ActiveProfiles("test")
@ContextConfiguration(locations = {"classpath:de/atabey/sample/steckerlfisch/test-context.xml"
        , "classpath:/de/atabey/sample/steckerlfisch/domain.xml"})
public class SteckerlfishFinderIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setUp() throws Exception {
        if (countRowsInTable("Stand") == 0) {
            super.executeSqlScript("classpath:de/atabey/sample/steckerlfisch/data.sql", false);
        }
    }

    @Autowired
    private SteckerlfischFinder steckerlfischFinder;

    @Test
    public void testFindSteckerlFischStandInDachauWhichIsOpen() throws Exception {
        List<Stand> staende = steckerlfischFinder.findStaendeIn("Dachau", Calendar.SATURDAY);
        assertNotNull(staende);
        assertEquals("Am Samstag hat der johann in Dachau geöffnet", 1, staende.size());
    }

    @Test
    public void testFindSteckerlFischStandInDachauWhichIsClosed() throws Exception {
        List<Stand> staende = steckerlfischFinder.findStaendeIn("Dachau", Calendar.MONDAY);
        assertNotNull(staende);
        assertEquals("Montag ist Ruhetag. Bitte nicht stören!", 0, staende.size());
    }
}
