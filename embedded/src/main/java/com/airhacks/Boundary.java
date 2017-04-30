package com.airhacks;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.logging.Logger;

public class Boundary {

    @Inject
    Instance<Control> control;

    @Inject
    Logger LOG;

    public String greeting() {
        LOG.info("about the greet");
        String prefix = "perfect";
        if (!control.isAmbiguous() && !control.isUnsatisfied()) {
            prefix = this.control.get().message();
        }
        return prefix + " day!";

    }
}
