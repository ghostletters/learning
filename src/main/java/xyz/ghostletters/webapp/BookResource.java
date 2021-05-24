package xyz.ghostletters.webapp;

import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import xyz.ghostletters.webapp.entity.Author;
import xyz.ghostletters.webapp.entity.Book;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("/book")
public class BookResource {

    @Inject
    RestClient restClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String searchBook(@QueryParam("query") String query) throws IOException {
        Request request = new Request("GET", "/book/_search");

        String payload = """
                {
                  "query": {
                    "match": {
                      "name": {
                        "query": "%s",
                        "fuzziness": "AUTO"
                      }
                    }
                  }
                }
                """.formatted(query);

        request.setJsonEntity(payload);

        Response response = restClient.performRequest(request);

        return EntityUtils.toString(response.getEntity());
    }
}
