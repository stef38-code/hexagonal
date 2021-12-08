package org.stephane.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonneDto {
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
}
