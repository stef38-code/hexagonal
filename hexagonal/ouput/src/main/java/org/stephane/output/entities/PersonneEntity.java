package org.stephane.output.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="personne")
public class PersonneEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    @NotEmpty
    private String nom;
    @NotEmpty
    private String prenom;
    @NotNull
    @Column(name ="datenaissance")
    private LocalDate dateNaissance;
    @ManyToMany(mappedBy = "personnes",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Set<AdresseEntity> adresses = new HashSet<>();
}
