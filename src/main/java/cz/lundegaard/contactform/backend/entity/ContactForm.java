package cz.lundegaard.contactform.backend.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CONTACT_FORM")
public class ContactForm extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "REQUEST_KIND_ID")
    private RequestKind requestKind;

    @Column(name = "POLICY_NUMBER")
    private String policyNumber;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "SECOND_NAME")
    private String secondName;
    @Column(name = "REQUEST_TEXT", length = 10000)
    private String requestText;

}
