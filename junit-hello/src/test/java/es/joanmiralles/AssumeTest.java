package es.joanmiralles;

import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNoException;

public class AssumeTest {

    @Test
    public void assumeNoExceptionDemonstration() {
        try {
            throw new IllegalStateException("Internet not available today");
        } catch (Exception e) {
            assumeNoException(e);
        }
        fail("should not arrive here");
    }
}
