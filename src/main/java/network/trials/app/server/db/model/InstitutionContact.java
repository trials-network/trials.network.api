package network.trials.app.server.db.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class InstitutionContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Institution institution;

    private String name;

    @Enumerated(EnumType.STRING)
    private ContactRole role;

    private String telephone;
    private String email;
    private String mobile;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactRole getRole() {
        return role;
    }

    public void setRole(ContactRole role) {
        this.role = role;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstitutionContact that = (InstitutionContact) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(institution, that.institution) &&
                Objects.equals(name, that.name) &&
                role == that.role &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(mobile, that.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, institution, name, role, telephone, email, mobile);
    }

    @Override
    public String toString() {
        return "InstitutionContact{" +
                "id=" + id +
                ", institution=" + institution +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}

