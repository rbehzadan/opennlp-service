package ir.behzadan.opennlp;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;


/**
 * Main class.
 *
 */
public class Main {
    public static final String BASE_URI = "http://0.0.0.0:6003/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("ir.behzadan.opennlp");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        OpenNLP nlp = OpenNLP.getInstance();
        final HttpServer server = startServer();
        Thread.currentThread().join();
        server.stop();
    }
}
