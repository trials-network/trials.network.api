package network.trials.app.server.db.repository;

import network.trials.app.server.db.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
