package es.joanmiralles;

import org.hamcrest.CustomMatcher;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class AssertionsShowTest {

    private List<String> stringList;

    @Before
    public void init() {
        stringList = Arrays.asList("java", "javaee", "joker");
    }

    @Test
    public void lists() {
        assertThat(stringList, hasItem("java"));
        assertThat(stringList, hasItem("javaee"));
        assertThat(stringList, hasItems("javaee", "joker"));
        assertThat(stringList, everyItem(containsString("j")));
    }

    @Test
    public void combinableMatchers() {
        assertThat(stringList, both(hasItem("java")).and(hasItem("javaee")));
        assertThat(stringList, either(hasItem("java")).or(hasItem("javascript")));
        assertThat(stringList, anyOf(hasItem("javascript"), hasItem("javaee")));
        assertThat(stringList, allOf(hasItem("java"), not(hasItem("erlang"))));
    }

    @Test
    public void customMatchers() {
        Matcher<String> containsJ = new CustomMatcher<String>("contains j") {

            @Override
            public boolean matches(Object item) {
                if (!(item instanceof String)) {
                    return false;
                }
                String content = (String) item;
                return content.contains("j");
            }
        };
        assertThat("javaee", containsJ);
    }
}
