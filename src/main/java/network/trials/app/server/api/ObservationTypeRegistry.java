package network.trials.app.server.api;

import network.trials.app.server.db.model.ObservationType;

import java.util.List;

public interface ObservationTypeRegistry {
    List<ObservationType> getObservationTypes();
}
