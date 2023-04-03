package com.example.td.DAO;

import com.example.td.Models.Departement;
import com.example.td.Models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;


@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

   //1
   @RestResource(path = "ee")
   @Query("SELECT e FROM Etudiant e JOIN e.departement d WHERE d.nomdepartement = 'Informatique' ORDER BY e.dateentree DESC\n")
   List<Etudiant>Etudiants();
   //localhost:8080/etudiants/search/ee

   Etudiant findByNumE(Long id);
   //localhost:8080/etudiants/search/findByNumE?id=1

   //2
   @Query("SELECT e.nom FROM Etudiant e WHERE e.nom LIKE '%L%' AND e.nom LIKE '%M%'")
   List<String> findEtudiantsWithLAndMInNom();

   //3
   @Query("select distinct e.departement from Etudiant e where e.dateentree = (select min(e.dateentree) from Etudiant )")
   Departement findMin();

   //4 : Donner la moyenne des Moyennes des étudiants
   @Query("SELECT AVG(e.moyenne) FROM Etudiant e")
   Double findAverageMoyenne();

   //5 : Donner les étudiants ayant les meilleurs moyens dans chaque département



}