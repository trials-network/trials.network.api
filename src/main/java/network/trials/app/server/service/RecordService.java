package network.trials.app.server.service;

import network.trials.app.server.api.Callback;
import network.trials.app.server.db.model.Patient;

import java.util.Optional;

public interface RecordService {
    void getPatient(Long id, Callback<Optional<Patient>, Exception> callback);

    void getPaymentByInstitutionId(Long institutionId, String patientId, Callback<Optional<Patient>, Exception> callback);



}
