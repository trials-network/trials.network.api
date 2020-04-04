package network.trials.app.server.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

//@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        packages("network.trials.app.server.rest");
    }
}