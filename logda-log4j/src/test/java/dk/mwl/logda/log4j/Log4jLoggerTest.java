package dk.mwl.logda.log4j;

import dk.mwl.logda.Logger;
import dk.mwl.logda.Message;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

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

    @Test
    public void willDebuglogToLog4j() throws Exception {
        String message = "MESSAGE";

        Message m = Mockito.mock(Message.class);
        org.apache.log4j.Logger log4j = PowerMockito.mock(org.apache.log4j.Logger.class);
        when(m.message()).thenReturn(message);
        when(log4j.isDebugEnabled()).thenReturn(true);

        Logger logger = new Log4jLogger(log4j);
        logger.debug(m);

        verify(log4j).debug(message);
    }

    @Test
    public void willDebuglogToLog4jWithException() throws Exception {
        String message = "MESSAGE";
        Throwable t = new RuntimeException("Test exception");

        Message m = Mockito.mock(Message.class);
        org.apache.log4j.Logger log4j = PowerMockito.mock(org.apache.log4j.Logger.class);
        when(m.message()).thenReturn(message);
        when(log4j.isDebugEnabled()).thenReturn(true);

        Logger logger = new Log4jLogger(log4j);
        logger.debug(m, t);

        verify(log4j).debug(message, t);
    }

    @Test
    public void willNotDebuglogToLog4jWhenLog4jThinksNot() throws Exception {
        String message = "MESSAGE";

        Message m = Mockito.mock(Message.class);
        org.apache.log4j.Logger log4j = mock(org.apache.log4j.Logger.class);
        when(log4j.isDebugEnabled()).thenReturn(false);

        Logger logger = new Log4jLogger(log4j);
        logger.debug(m);

        verify(log4j, never()).debug(message);
        verifyZeroInteractions(m);
    }

    @Test
    public void canLegacyDebugLog() throws Exception {
        String message = "MESSAGE";

        org.apache.log4j.Logger log4j = mock(org.apache.log4j.Logger.class);

        Logger logger = new Log4jLogger(log4j);
        logger.debug(message);

        verify(log4j).debug(message);
    }

    @Test
    public void canLegacyDebugLogWithException() throws Exception {
        String message = "MESSAGE";
        Throwable t = new RuntimeException("Test exception");

        org.apache.log4j.Logger log4j = mock(org.apache.log4j.Logger.class);

        Logger logger = new Log4jLogger(log4j);
        logger.debug(message, t);

        verify(log4j).debug(message, t);
    }
}
