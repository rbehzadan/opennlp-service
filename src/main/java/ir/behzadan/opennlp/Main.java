package ir.behzadan.opennlp;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;


public class Main {
    static final String DEFAULT_HOST = "0.0.0.0";
    static final String DEFAULT_PORT = "80";
    public static String BASE_URI;

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("ir.behzadan.opennlp");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String host = System.getenv("OPENNLP_SERVICE_HOST");
        String port = System.getenv("OPENNLP_SERVICE_PORT");
        host = (host == null) ? DEFAULT_HOST : host;
        port = (port == null) ? DEFAULT_PORT : port;
        BASE_URI = "http://" + host + ":" + port + "/";

        OpenNLP nlp = OpenNLP.getInstance();
        final HttpServer server = startServer();
        Thread.currentThread().join();
        server.stop();
    }
}
