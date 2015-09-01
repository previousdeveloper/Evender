package Controller;

import static spark.SparkBase.port;
import static spark.SparkBase.threadPool;

/**
 * Created by previousdeveloper on 2.09.2015.
 */
public class ServerConfiguration {
    public ServerConfiguration() {
        int maxThreads = 100;
        int minThreads = 20;
        int timeOutMillis = 30000;
        threadPool(maxThreads, minThreads, timeOutMillis);

        port(8080);
    }
}
