package LMS;
import java.util.logging.*;
public class Log {
    static final Logger logger = Logger.getLogger(Log.class.getName());
    static {
        ConsoleHandler handler = new ConsoleHandler();
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
        handler.setFormatter(new SimpleFormatter());
    }
}

