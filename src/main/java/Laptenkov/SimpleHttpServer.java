package Laptenkov;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class SimpleHttpServer {

    private final static Logger LOGGER = Logger.getLogger(SimpleHttpServer.class.getName());
    public static final String HOSTNAME = "0.0.0.0";
    public static final int PORT = 8001;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(HOSTNAME, PORT), 0);
        server.createContext("/", new  MyHttpHandler());
        server.setExecutor(Executors.newFixedThreadPool(10));
        server.start();
        LOGGER.info(String.format("Server started on port %d", PORT));
    }
}
