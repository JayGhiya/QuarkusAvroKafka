package org.acme.kafka;

import org.acme.kafka.quarkus.Observation;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/observations")
public class MovieResource {
    private static final Logger LOGGER = Logger.getLogger(MovieResource.class);

    @Channel("observation")
    Emitter<Observation> emitter;

    @POST
    public Response enqueueMovie(Observation movie) {
        emitter.send(movie);
        return Response.accepted().build();
    }

}
