package com.example.td.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numE;
    @NonNull
    private String nom;
    @NonNull
    private int niveau;
    @NonNull
    @Temporal(TemporalType.DATE)
    private Date dateentree;

//    @JsonIgnore
    @NonNull
    @ManyToOne
    @JoinColumn(name = "ID_spécialité")
    private Specialite specialite;

//    @JsonIgnore
    @NonNull
    @ManyToOne
    @JoinColumn(name = "ID_departement")
    private Departement departement;
    @NonNull
    private float moyenne;

}
