package com.airhacks.mon.reporting.boundary;

import org.junit.Rule;
import org.junit.Test;

import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class SnapshotsResourceIT {

    @Rule
    public JAXRSClient provider = JAXRSClient.target("http://localhost:8080/monitoring/resources/snapshots");

    @Test
    public void snapshots() {
        Response response = this.provider.tut().request(MediaType.APPLICATION_JSON).get();
        assertThat(response.getStatus(), is(200));
        JsonObject result = response.readEntity(JsonObject.class);
        assertNotNull(result);
        System.out.println("result = " + result);
    }



}
