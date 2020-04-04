package network.trials.app.server.db.repository;

import network.trials.app.server.db.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.institution.id = :institutionId and p.institutionCorrelationId = :patientId")
    List<Patient> findTop1PatientByInstitutionIdAndPatientId(
            @Param("institutionId") Long institutionId,
            @Param("patientId") String patientId
    );
}
