package com.airhacks;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Arquillian.class)
public class BoundarySinglePluginIT {
    @Inject
    Boundary boundary;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class).
                addClasses(LoggerProducer.class, Boundary.class, FriendlyMessenger.class, Control.class).
                addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void boundarySinglePlugin() {
        String expected = ":-) day!";
        String actual = boundary.greeting();
        assertThat(actual, is(expected));
    }
}