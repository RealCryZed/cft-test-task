import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.*;

/**
 * MyLogger is a custom logger. It has Singleton Pattern.
 */
class MyLogger {
    private static MyLogger instance;
    private Logger logger = Logger.getLogger("MyLog");

    private MyLogger() throws IOException {

    }

    public static MyLogger getLogger(){
        if(instance == null){
            try {
                instance = new MyLogger();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * Custom log method.
     * @param level logging level
     * @param msg information about this log
     */
    public void log(Level level, String msg){
        logger.log(level, msg);
    }
}