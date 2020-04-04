package network.trials.app.server.db.repository;

import network.trials.app.server.db.model.AllergyRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRecordRepository extends JpaRepository<AllergyRecord, Long> {
}
