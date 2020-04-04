package network.trials.app.server.db.repository;

import network.trials.app.server.db.model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
}
