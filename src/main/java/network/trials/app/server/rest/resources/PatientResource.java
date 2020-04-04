package network.trials.app.server.rest.resources;

import network.trials.app.server.db.repository.PatientRepository;
import network.trials.app.server.db.model.Institution;
import network.trials.app.server.db.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/patients")
public class PatientResource {

    @Autowired
    PatientRepository patientRepository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientList(@QueryParam("institution") Long institutionId,
                                   @QueryParam("patientId") String patientId) {

        Patient example = new Patient();
        if (null != institutionId) {
            Institution i = new Institution();
            i.setId(institutionId);
            example.setInstitution(i);
        }

        if (null != patientId) {
            example.setInstitutionCorrelationId(patientId);
        }

        return Response.ok(patientRepository.findAll(Example.of(example))).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("id") Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return Response.ok(patient.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
