package com.airhacks.delta;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(CdiTestRunner.class)
public class InjectEmAllIT {


    @Inject
    Boundary boundary;

    @Test
    public void injection() {
        assertNotNull(boundary);
        String expected = "perfect day!";
        String greeting = boundary.greeting();
        assertThat(greeting, is(expected));
    }

}
