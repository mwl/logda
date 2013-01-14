package dk.mwl.logda;

import dk.mwl.logda.log4j.Log4jLogger;

public class LoggerFactory {
    public static Logger getLogger(String type) {
        return new Log4jLogger(type);
    }

    public static Logger getLogger(Class clazz) {
        return new Log4jLogger(clazz);
    }
}
