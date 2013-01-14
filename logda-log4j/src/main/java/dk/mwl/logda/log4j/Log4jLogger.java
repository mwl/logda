package dk.mwl.logda.log4j;

import dk.mwl.logda.Logger;
import dk.mwl.logda.Message;

public class Log4jLogger implements Logger {
    org.apache.log4j.Logger logger;

    Log4jLogger(org.apache.log4j.Logger logger) {
        this.logger = logger;
    }

    public Log4jLogger(String name) {
        this(org.apache.log4j.Logger.getLogger(name));
    }

    public Log4jLogger(Class clazz) {
        this(org.apache.log4j.Logger.getLogger(clazz));
    }

    @Override
    public void debug(Message m) {
        if (logger.isDebugEnabled()) {
            logger.debug(m.message());
        }
    }

    @Override
    public void debug(Message m, Throwable t) {
        if (logger.isDebugEnabled()) {
            logger.debug(m.message(), t);
        }
    }

    @Override
    public void debug(Object m) {
        logger.debug(m);
    }

    @Override
    public void debug(Object m, Throwable t) {
        logger.debug(m, t);
    }

    public org.apache.log4j.Logger getLogger() {
        return logger;
    }
}
