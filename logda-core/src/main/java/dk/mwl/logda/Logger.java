package dk.mwl.logda;

public interface Logger {
    void debug(Message m);

    void debug(Message m, Throwable t);

    void debug(Object m);

    void debug(Object m, Throwable t);

}
