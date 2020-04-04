package network.trials.app.server.graphql;

import graphql.schema.DataFetcher;
import network.trials.app.server.api.ObservationTypeRegistry;
import network.trials.app.server.db.model.*;
import network.trials.app.server.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AllergyRecordRepository allergyRecordRepository;

    @Autowired
    InstitutionContactRepository institutionContactRepository;

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    ObservationRepository observationRepository;

    @Autowired
    ConditionRepository conditionRepository;

    @Autowired
    ObservationTypeRegistry observationTypeRegistry;


    public DataFetcher<List<Institution>> getInstitutionsDataFetcher() {
        return env -> institutionRepository.findAll();
    }

    public DataFetcher<Institution> getInstitutionDataFetcher() {
        return env -> {
            Long id = env.getArgument("id");
            return institutionRepository.findById(id).orElseThrow();
        };
    }


    public DataFetcher<List<InstitutionContact>> getInstitutionContactsDataFetcher() {
        return env -> {
            Institution        institution = env.getSource();
            InstitutionContact ex          = new InstitutionContact();
            ex.setInstitution(institution);
            return institutionContactRepository.findAll(Example.of(ex));
        };
    }

    public DataFetcher<List<Patient>> getInstitutionPatientsDataFetcher() {
        return env -> {
            Institution institution = env.getSource();
            Patient     ex          = new Patient();
            ex.setInstitution(institution);
            return patientRepository.findAll(Example.of(ex));
        };
    }


    public DataFetcher<List<Patient>> getPatientsFetcher() {
        return env -> patientRepository.findAll();
    }

    public DataFetcher<Patient> getPatientFetcher() {
        return env -> {
            Long id = env.getArgument("id");
            return patientRepository.findById(id).orElseThrow();
        };
    }

    public DataFetcher<Patient> getPatientByInstitutionFetcher() {
        return env -> {
            Long          institutionId = env.getArgument("institutionId");
            String        patientId     = env.getArgument("patientId");
            List<Patient> patientList   = patientRepository.findTop1PatientByInstitutionIdAndPatientId(institutionId, patientId);
            if (!patientList.isEmpty()) {
                return patientList.iterator().next();
            } else {
                throw new Exception("Not found");
            }
        };
    }


    public DataFetcher<Institution> getAddInstitutionDataFetcher() {
        return env -> {
            Map<String, Object> input = env.getArgument("institution");
            Institution         i     = new Institution();
            i.setAddress((String) input.get("address"));
            i.setName((String) input.get("name"));
            i.setTimezone((String) input.get("timezone"));

            return institutionRepository.save(i);
        };
    }


    public DataFetcher<Institution> getUpdateInstitutionDataFetcher() {
        return env -> {
            Map<String, Object> input = env.getArgument("institution");
            Long                id    = env.getArgument("id");

            Institution i = institutionRepository.findById(id).orElseThrow();
            i.setId(id);
            i.setAddress((String) input.get("address"));
            i.setName((String) input.get("name"));
            i.setTimezone((String) input.get("timezone"));

            return institutionRepository.save(i);
        };
    }

    public DataFetcher<InstitutionContact> getAddInstitutionContactDataFetcher() {
        return env -> {
            Long                id    = env.getArgument("institutionId");
            Map<String, Object> input = env.getArgument("contact");
            Institution         i     = institutionRepository.findById(id).orElseThrow();

            InstitutionContact contact = new InstitutionContact();
            contact.setInstitution(i);
            contact.setName((String) input.get("name"));
            contact.setEmail((String) input.get("email"));
            contact.setMobile((String) input.get("mobile"));
            contact.setTelephone((String) input.get("telephone"));
            contact.setRole(ContactRole.valueOf((String) input.get("role")));

            return institutionContactRepository.save(contact);
        };
    }


    public DataFetcher<InstitutionContact> getUpdateInstitutionContactDataFetcher() {
        return env -> {
            Map<String, Object> input = env.getArgument("contact");
            Long                id    = env.getArgument("id");

            InstitutionContact contact = institutionContactRepository.findById(id).orElseThrow();
            contact.setName((String) input.get("name"));
            contact.setEmail((String) input.get("email"));
            contact.setMobile((String) input.get("mobile"));
            contact.setTelephone((String) input.get("telephone"));
            contact.setRole(ContactRole.valueOf((String) input.get("role")));

            return institutionContactRepository.save(contact);

        };
    }

    public DataFetcher<Patient> getAddPatientDataFetcher() {
        return env -> {

            Map<String, Object> input         = env.getArgument("patient");
            Long                institutionId = (Long) input.get("institutionId");
            Institution         institution   = institutionRepository.findById(institutionId).orElseThrow();

            Patient p = new Patient();
            p.setInstitution(institution);
            p.setName((String) input.get("name"));
            p.setInstitutionCorrelationId((String) input.get("institutionCorrelationId"));
            p.setGender(Gender.valueOf((String) input.get("gender")));
            p.setEthnicity(Ethnicity.valueOf((String) input.get("ethnicity")));
            p.setCovidHospitalizationDate((LocalDate) input.get("covidHospitalizationDate"));
            p.setCovidSymptomsStartDate((LocalDate) input.get("covidSymptomsStartDate"));

            return patientRepository.save(p);
        };
    }

    public DataFetcher<Patient> getUpdatePatientDataFetcher() {
        return env -> {
            Long                id    = env.getArgument("id");
            Map<String, Object> input = env.getArgument("patient");
            Patient             p     = patientRepository.findById(id).orElseThrow();

            p.setName((String) input.get("name"));
            p.setInstitutionCorrelationId((String) input.get("institutionCorrelationId"));
            p.setGender(Gender.valueOf((String) input.get("gender")));
            p.setEthnicity(Ethnicity.valueOf((String) input.get("ethnicity")));
            p.setCovidHospitalizationDate((LocalDate) input.get("covidHospitalizationDate"));
            p.setCovidSymptomsStartDate((LocalDate) input.get("covidSymptomsStartDate"));

            patientRepository.save(p);

            return p;
        };
    }

    public DataFetcher<List<ObservationType>> getObservationTypesFetcher() {
        return env -> observationTypeRegistry.getObservationTypes();
    }
}