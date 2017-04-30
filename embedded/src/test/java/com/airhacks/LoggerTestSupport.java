package com.airhacks;

import javax.inject.Inject;
import java.util.logging.Logger;

public class LoggerTestSupport {

    @Inject
    Logger LOG;

    public Logger getLog() {
        return LOG;
    }
}
