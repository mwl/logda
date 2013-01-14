package dk.mwl.logda.log4j;

import dk.mwl.logda.Logger;
import dk.mwl.logda.Message;
import org.apache.log4j.Level;

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

    public void log(Level level, Message m) {
        if (logger.isEnabledFor(level)) {
            logger.log(level, m.message());
        }
    }
    public void log(Level level, Message m, Throwable t) {
        if (logger.isEnabledFor(level)) {
            logger.log(level, m.message(), t);
        }
    }

    @Override
    public void debug(Message m) {
        log(Level.DEBUG, m);
    }

    @Override
    public void debug(Message m, Throwable t) {
        log(Level.DEBUG, m, t);
    }

    @Override
    public void debug(Object m) {
        logger.debug(m);
    }

    @Override
    public void debug(Object m, Throwable t) {
        logger.debug(m, t);
    }

    @Override
    public void info(Message m) {
        log(Level.INFO, m);
    }

    @Override
    public void info(Message m, Throwable t) {
        log(Level.INFO, m, t);
    }

    @Override
    public void info(Object m) {
        logger.info(m);
    }

    @Override
    public void info(Object m, Throwable t) {
        logger.info(m, t);
    }

    @Override
    public void warn(Message m) {
        log(Level.WARN, m);
    }

    @Override
    public void warn(Message m, Throwable t) {
        log(Level.WARN, m, t);
    }

    @Override
    public void warn(Object m) {
        logger.warn(m);
    }

    @Override
    public void warn(Object m, Throwable t) {
        logger.warn(m, t);
    }

    @Override
    public void error(Message m) {
        log(Level.ERROR, m);
    }

    @Override
    public void error(Message m, Throwable t) {
        log(Level.ERROR, m, t);
    }

    @Override
    public void error(Object m) {
        logger.error(m);
    }

    @Override
    public void error(Object m, Throwable t) {
        logger.error(m, t);
    }

    @Override
    public void fatal(Message m) {
        log(Level.FATAL, m);
    }

    @Override
    public void fatal(Message m, Throwable t) {
        log(Level.FATAL, m, t);
    }

    @Override
    public void fatal(Object m) {
        logger.fatal(m);
    }

    @Override
    public void fatal(Object m, Throwable t) {
        logger.fatal(m, t);
    }

    public org.apache.log4j.Logger getLogger() {
        return logger;
    }
}
