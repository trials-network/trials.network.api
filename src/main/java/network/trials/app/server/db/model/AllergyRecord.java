package network.trials.app.server.db.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AllergyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AllergyType type;

    private String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AllergyType getType() {
        return type;
    }

    public void setType(AllergyType type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllergyRecord that = (AllergyRecord) o;
        return Objects.equals(id, that.id) &&
                type == that.type &&
                Objects.equals(details, that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, details);
    }

    @Override
    public String toString() {
        return "AllergyRecord{" +
                "id=" + id +
                ", type=" + type +
                ", details='" + details + '\'' +
                '}';
    }
}
