import de.atabey.sample.steckerlfisch.model.Stand;
import de.atabey.sample.steckerlfisch.model.SteckerlfischFinder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;
import sun.security.util.Resources_it;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Fuat Atabey
 */
@ContextConfiguration(locations = {"classpath:de/atabey/sample/steckerlfisch/test-context.xml"
        ,"classpath:/de/atabey/sample/steckerlfisch/domain.xml"})
public class SteckerlfishFinderIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setUp() throws Exception {
        super.executeSqlScript("classpath:de/atabey/sample/steckerlfisch/data.sql", false);

    }

    @Autowired
    private SteckerlfischFinder steckerlfischFinder;

    @Test
    public void testFindSteckerlFischStandInDachau() throws Exception {
        List<Stand> staende = steckerlfischFinder.findStaendeIn("Dachau");
        assertNotNull(staende);
        assertEquals("Ich weiss dass in Dachau ein Stand vorhanden ist", 1, staende.size());
    }
}
