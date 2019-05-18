package cz.lundegaard.contactform.backend.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "REQUEST_KIND")
public class RequestKind extends BaseEntity {

    @Column(name = "CODE")
    private String code;

    @Column(name = "TEXT")
    private String text;
}
