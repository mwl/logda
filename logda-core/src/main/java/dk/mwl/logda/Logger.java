package dk.mwl.logda;

public interface Logger {
    void debug(Message m);
    void debug(Message m, Throwable t);
    void debug(Object m);
    void debug(Object m, Throwable t);

    void info(Message m);
    void info(Message m, Throwable t);
    void info(Object m);
    void info(Object m, Throwable t);

    void warn(Message m);
    void warn(Message m, Throwable t);
    void warn(Object m);
    void warn(Object m, Throwable t);

    void error(Message m);
    void error(Message m, Throwable t);
    void error(Object m);
    void error(Object m, Throwable t);

    void fatal(Message m);
    void fatal(Message m, Throwable t);
    void fatal(Object m);
    void fatal(Object m, Throwable t);

}
