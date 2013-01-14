package dk.mwl.logda.log4j;

import dk.mwl.logda.Logger;
import dk.mwl.logda.LoggerFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(org.apache.log4j.Logger.class)
public class Log4jLoggerTest {
    @Before
    public void setUp() throws Exception {
        mockStatic(org.apache.log4j.Logger.class);
    }

    @Test
    public void canCreateALog4jLoggerFromName() throws Exception {
        String name = "SOME TYPE";
        Logger logger = new Log4jLogger(name);

        verifyStatic();
        org.apache.log4j.Logger.getLogger(name);
    }

    @Test
    public void canCreateALog4jLoggerFromType() throws Exception {
        Class<Log4jLoggerTest> clazz = Log4jLoggerTest.class;
        Logger logger = new Log4jLogger(clazz);

        verifyStatic();
        org.apache.log4j.Logger.getLogger(clazz);
    }
}
