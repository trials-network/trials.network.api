package network.trials.app.server.db.model;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    private Patient patient;

    private String observationTypeId;

    private float  value;

    private OffsetDateTime valueTime;

    private OffsetDateTime timeRecorded;

    private String notes;

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

    public String getObservationTypeId() {
        return observationTypeId;
    }

    public void setObservationTypeId(String observationTypeId) {
        this.observationTypeId = observationTypeId;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public OffsetDateTime getValueTime() {
        return valueTime;
    }

    public void setValueTime(OffsetDateTime valueTime) {
        this.valueTime = valueTime;
    }

    public OffsetDateTime getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(OffsetDateTime timeRecorded) {
        this.timeRecorded = timeRecorded;
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
        Observation that = (Observation) o;
        return Float.compare(that.value, value) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(observationTypeId, that.observationTypeId) &&
                Objects.equals(valueTime, that.valueTime) &&
                Objects.equals(timeRecorded, that.timeRecorded) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patient, observationTypeId, value, valueTime, timeRecorded, notes);
    }

    @Override
    public String toString() {
        return "Observation{" +
                "id=" + id +
                ", patient=" + patient +
                ", observationTypeId='" + observationTypeId + '\'' +
                ", value=" + value +
                ", valueTime=" + valueTime +
                ", timeRecorded=" + timeRecorded +
                ", notes='" + notes + '\'' +
                '}';
    }
}
