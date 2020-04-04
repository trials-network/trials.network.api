package network.trials.app.server.db.repository;

import network.trials.app.server.db.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<Observation, Long> {
}
