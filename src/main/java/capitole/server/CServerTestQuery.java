package capitole.server;

import capitole.classes.CDate;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;

/**
 * Created by clemzux on 28/10/16.
 */
public class CServerTestQuery {

    public static void main(String[] args) {

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        WebResource webResource = c.resource("http://localhost:9998/");
//        WebResource webResource = c.resource("http://176.157.85.69:9998/");

        CDate d1 = new CDate();

        d1.setId(1);
        d1.setDate("28-10-2016");

        webResource.path("dates").type(MediaType.APPLICATION_JSON).post(d1);
    }
}
