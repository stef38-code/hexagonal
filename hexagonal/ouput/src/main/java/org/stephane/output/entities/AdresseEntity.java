package org.stephane.output.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="adresse")
public class AdresseEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String appartementEscalierEtage;
    private String batimentResidence;
    private String numeroNomVoie;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String pays;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(name = "personne_adresse",
            joinColumns = @JoinColumn(name = "personne_id"),
            inverseJoinColumns = @JoinColumn(name = "adresse_id")
    )

    private Set<PersonneEntity> personnes = new LinkedHashSet<>();
}
