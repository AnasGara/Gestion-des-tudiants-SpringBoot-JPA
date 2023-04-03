package com.example.td.Models;


import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nomdepartement;


    @OneToMany(mappedBy = "departement",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Etudiant>Etudiants;


}
