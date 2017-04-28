package com.airhacks.mon.reporting.boundary;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import org.junit.Rule;
import org.junit.Test;

import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.airhacks.rulz.jaxrsclient.HttpMatchers.successful;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class SnapshotsResourceIT {

    @Rule
    public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/monitoring/resources/snapshots");

    @Test
    public void snapshots() {
        Response response = this.provider.target().request(MediaType.APPLICATION_JSON).get();
        assertThat(response, successful());
        JsonObject result = response.readEntity(JsonObject.class);
        assertNotNull(result);
        System.out.println("result = " + result);
    }



}
