package server;

import jakarta.xml.ws.Endpoint;
import ws.BanqueServices;

public class ServerJWS {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:4747/";

        Endpoint.publish(url, new BanqueServices());
        System.out.println("Web Service prêt sur "+url);
    }
}
