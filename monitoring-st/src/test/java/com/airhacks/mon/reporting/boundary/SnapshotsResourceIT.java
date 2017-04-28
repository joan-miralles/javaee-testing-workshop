package com.airhacks.mon.reporting.boundary;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import org.junit.Rule;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class SnapshotsResourceIT {

    @Rule
    public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/monitoring/resources/snapshots");

    @Test
    public void crud() {
        String key = "java";
        String value = "rocks";
        JsonObject payload = Json.createObjectBuilder().add(key, value).build();

        Response response = this.provider.target().
                request(MediaType.APPLICATION_JSON).
                post(Entity.json(payload));
        assertThat(response.getStatus(), is(201));
        String uri = response.getHeaderString("Location");
        assertNotNull(uri);
        JsonObject result = provider.target(uri).request(MediaType.APPLICATION_JSON).get(JsonObject.class);
        assertNotNull(result);
        assertThat(result.getString(key), is(value));
    }

    @Test
    public void findNotExisting() {
        String key = UUID.randomUUID().toString();
        Response response = this.provider.target().path(key).request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(204));
    }
}
