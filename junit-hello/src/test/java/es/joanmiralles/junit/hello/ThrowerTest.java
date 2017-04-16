package es.joanmiralles.junit.hello;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ThrowerTest {

    private Thrower cut;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        this.cut = new Thrower();
    }

    @Test(expected = IllegalStateException.class)
    public void exception() {
        this.cut.throwExcetion();
    }

    @Test
    public void detailedException() {
        try {
            this.cut.throwExcetion();
            fail("Expecting IllegalStateException");
        } catch (IllegalStateException e) {
            String message = e.getMessage();
            assertThat(message, containsString("illegal"));
        }
    }

    @Test
    public void exceptionWithRule() {
        this.thrown.expect(IllegalStateException.class);
        this.thrown.expectMessage(containsString("illegal"));
        this.cut.throwExcetion();
    }

}