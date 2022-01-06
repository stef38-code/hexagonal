package org.stephane.output.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personne")
@EntityListeners(AuditingEntityListener.class)
public class PersonneEntity extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    @NotNull
    @Column(name = "datenaissance")
    private LocalDate dateNaissance;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = AdresseEntity.class, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonBackReference
    @JoinTable(name = "personne_adresse", joinColumns = {@JoinColumn(name = "PERSONNE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ADRESSE_ID", nullable = false)})
    @Fetch(FetchMode.SELECT)
    private Set<AdresseEntity> adresses = new HashSet<>();
}
