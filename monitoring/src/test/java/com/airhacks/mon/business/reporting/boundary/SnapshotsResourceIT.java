package com.airhacks.mon.business.reporting.boundary;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.json.JsonObject;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SnapshotsResourceIT extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(SnapshotsResource.class);
    }

    @Test
    public void crud() {
        Response response = target("find").request().get();
        assertThat(response.getStatus(), is(200));
        JsonObject result = response.readEntity(JsonObject.class);
        System.out.println("result = " + result);
    }

}