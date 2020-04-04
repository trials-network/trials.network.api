package network.trials.app.server.db.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    Institution institution;

    private String institutionCorrelationId; // anonymized id

    @Enumerated
    private Gender    gender;
    private LocalDate dateOfBirth;

    @Enumerated
    private Ethnicity ethnicity;

    private LocalDate covidSymptomsStartDate;
    private LocalDate covidHospitalizationDate;

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getInstitutionCorrelationId() {
        return institutionCorrelationId;
    }

    public void setInstitutionCorrelationId(String institutionCorrelationId) {
        this.institutionCorrelationId = institutionCorrelationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    public LocalDate getCovidSymptomsStartDate() {
        return covidSymptomsStartDate;
    }

    public void setCovidSymptomsStartDate(LocalDate covidSymptomsStartDate) {
        this.covidSymptomsStartDate = covidSymptomsStartDate;
    }

    public LocalDate getCovidHospitalizationDate() {
        return covidHospitalizationDate;
    }

    public void setCovidHospitalizationDate(LocalDate covidHospitalizationDate) {
        this.covidHospitalizationDate = covidHospitalizationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(institution, patient.institution) &&
                Objects.equals(institutionCorrelationId, patient.institutionCorrelationId) &&
                gender == patient.gender &&
                Objects.equals(dateOfBirth, patient.dateOfBirth) &&
                ethnicity == patient.ethnicity &&
                Objects.equals(covidSymptomsStartDate, patient.covidSymptomsStartDate) &&
                Objects.equals(covidHospitalizationDate, patient.covidHospitalizationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, institution, institutionCorrelationId, gender, dateOfBirth, ethnicity, covidSymptomsStartDate, covidHospitalizationDate);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", institution=" + institution +
                ", institutionCorrelationId='" + institutionCorrelationId + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", ethnicity=" + ethnicity +
                ", covidSymptomsStartDate=" + covidSymptomsStartDate +
                ", covidHospitalizationDate=" + covidHospitalizationDate +
                '}';
    }
}
