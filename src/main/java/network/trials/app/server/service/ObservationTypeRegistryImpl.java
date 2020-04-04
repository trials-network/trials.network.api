package network.trials.app.server.service;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import network.trials.app.server.api.ObservationTypeRegistry;
import network.trials.app.server.db.model.ObservationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Component
public class ObservationTypeRegistryImpl implements ObservationTypeRegistry {
    private static final Logger                LOG           = LoggerFactory.getLogger(ObservationTypeRegistryImpl.class);
    private              Type                  LIST_OB_TYPES = new TypeToken<List<ObservationType>>() {
    }.getType();
    private              List<ObservationType> mTypes        = Collections.emptyList();

    @PostConstruct
    public void init() {
        try {
            mTypes = new Gson().fromJson(
                    Resources.toString(new URL("classpath:measurements.json"), StandardCharsets.UTF_8),
                    LIST_OB_TYPES);
        } catch (IOException e) {
            LOG.warn("Could not load observation types", e);
        }
    }

    @Override
    public List<ObservationType> getObservationTypes() {
        return mTypes;
    }
}
