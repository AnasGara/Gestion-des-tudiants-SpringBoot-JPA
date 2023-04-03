package com.example.td;

import com.example.td.DAO.DepartementRepository;
import com.example.td.DAO.EtudiantRepository;
import com.example.td.DAO.SpecialiteRepository;
import com.example.td.Models.Departement;
import com.example.td.Models.Etudiant;
import com.example.td.Models.Specialite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class TdApplication implements ApplicationRunner {

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private SpecialiteRepository specialiteRepository;
    @Autowired
    private DepartementRepository departementRepository;
    public static void main(String[] args) {
        SpringApplication.run(TdApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        //error :department and specialite objects should be saved before etudiant object
            //Etudiant etudiant5 = new Etudiant("Ali", 1, new Date(2014-10-10), new Specialite("Genie Logiciel"), new Departement("Informatique"),8.35f);
            //etudiantRepository.save(etudiant5);



//        First, save the "Specialite" and "Departement" objects to the database
        Specialite specialite1 = new Specialite("Genie Logiciel");
        Specialite specialite2 = new Specialite("Intelligence Artificielle");
        Specialite specialite3 = new Specialite("Management");

        Departement departement1 = new Departement("Informatique");
        Departement departement2 = new Departement("Management et Ressources humaines");
        specialiteRepository.saveAll(Arrays.asList(specialite1,specialite2,specialite3));
        departementRepository.saveAll(Arrays.asList(departement1,departement2));

        // Now create the "Etudiant" object using the saved "Specialite" and "Departement" objects
        Etudiant etudiant1 = new Etudiant("Ali", 1, new Date(2014 - 1900, Calendar.OCTOBER,10), specialite1, departement1,8.35f);
        Etudiant etudiant2 = new Etudiant("Sami", 3, new Date(2012 - 1900,Calendar.OCTOBER,9), specialite1, departement1, 12.12f);
        Etudiant etudiant3 = new Etudiant("Fethi", 2, new Date(2013 - 1900,Calendar.OCTOBER,9),  specialite2, departement1,14.10f);
        Etudiant etudiant4 = new Etudiant("Yassine", 1, new Date(2014 - 1900,Calendar.OCTOBER,8),  specialite3, departement2,9.35f);

        etudiantRepository.saveAll(Arrays.asList(etudiant1,etudiant2,etudiant3,etudiant4));


    }
}
