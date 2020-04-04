package network.trials.app.server.graphql;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        URL           url           = Resources.getResource("schema.graphqls");
        String        sdl           = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry    = new SchemaParser().parse(sdl);
        RuntimeWiring          runtimeWiring   = buildWiring();
        SchemaGenerator        schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .scalar(ExtendedScalars.DateTime)
                .scalar(ExtendedScalars.Date)
                .scalar(ExtendedScalars.Time)
                .scalar(ExtendedScalars.Url)
                .type(newTypeWiring("Query")
                        .dataFetcher("institutions", graphQLDataFetchers.getInstitutionsDataFetcher())
                        .dataFetcher("institution", graphQLDataFetchers.getInstitutionDataFetcher())
                        .dataFetcher("patients", graphQLDataFetchers.getPatientsFetcher())
                        .dataFetcher("patient", graphQLDataFetchers.getPatientFetcher())
                        .dataFetcher("observationTypes", graphQLDataFetchers.getObservationTypesFetcher())
                        .dataFetcher("patientByInstitution", graphQLDataFetchers.getPatientByInstitutionFetcher())
                ).type(newTypeWiring("Patient")
                ).type(newTypeWiring("Institution")
                        .dataFetcher("patients", graphQLDataFetchers.getInstitutionPatientsDataFetcher())
                        .dataFetcher("contacts", graphQLDataFetchers.getInstitutionContactsDataFetcher())
                ).type(newTypeWiring("Mutation")
                        .dataFetcher("addInstitution", graphQLDataFetchers.getAddInstitutionDataFetcher())
                        .dataFetcher("updateInstitution", graphQLDataFetchers.getUpdateInstitutionDataFetcher())
                        .dataFetcher("addInstitutionContact", graphQLDataFetchers.getAddInstitutionContactDataFetcher())
                        .dataFetcher("updateInstitutionContact", graphQLDataFetchers.getUpdateInstitutionContactDataFetcher())
                        .dataFetcher("addPatient", graphQLDataFetchers.getAddPatientDataFetcher())
                        .dataFetcher("updatePatient", graphQLDataFetchers.getUpdatePatientDataFetcher())
                ).build();
    }

}