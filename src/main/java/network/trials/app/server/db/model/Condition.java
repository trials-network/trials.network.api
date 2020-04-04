package network.trials.app.server.db.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Patient patient;

    private String name;
    private String medications; // active medications

    @Enumerated
    private ConditionState state;

    private LocalDate date; // active (since), inactive (since), history_of (last occurred)
    private String    notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public ConditionState getState() {
        return state;
    }

    public void setState(ConditionState state) {
        this.state = state;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condition condition = (Condition) o;
        return Objects.equals(id, condition.id) &&
                Objects.equals(patient, condition.patient) &&
                Objects.equals(name, condition.name) &&
                Objects.equals(medications, condition.medications) &&
                state == condition.state &&
                Objects.equals(date, condition.date) &&
                Objects.equals(notes, condition.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, name, medications, state, date, notes);
    }

    @Override
    public String toString() {
        return "Condition{" +
                "id=" + id +
                ", patient=" + patient +
                ", name='" + name + '\'' +
                ", medications='" + medications + '\'' +
                ", state=" + state +
                ", date=" + date +
                ", notes='" + notes + '\'' +
                '}';
    }
}
