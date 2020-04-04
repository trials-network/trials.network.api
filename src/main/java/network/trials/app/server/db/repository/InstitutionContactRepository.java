package network.trials.app.server.db.repository;

import network.trials.app.server.db.model.InstitutionContact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionContactRepository extends JpaRepository<InstitutionContact, Long> {
}
