package Laptenkov;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

public class MyHttpHandler implements HttpHandler {
    private static final Logger LOGGER = Logger.getLogger(MyHttpHandler.class.getName());

    public void handle(HttpExchange httpExchange) throws IOException {
        handleRequest(httpExchange);
        LOGGER.info("handleOtherRequest finished");
    }

    private void handleRequest(HttpExchange httpExchange) throws IOException {
        System.out.println(httpExchange.getRequestHeaders().entrySet());

        OutputStream outputStream = httpExchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<html>")
                .append("<body>")
                .append("<h1>")
                .append("Method: " + httpExchange.getRequestMethod())
                .append(" on uri: " + httpExchange.getRequestURI())
                .append("</h1>")
                .append("</body>")
                .append("</html>");

        String htmlResponse = htmlBuilder.toString();
        httpExchange.sendResponseHeaders(200, htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
