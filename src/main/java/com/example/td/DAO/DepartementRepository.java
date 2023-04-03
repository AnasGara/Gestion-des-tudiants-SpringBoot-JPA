package com.example.td.DAO;

import com.example.td.Models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource

public interface DepartementRepository extends JpaRepository<Departement, Long> {

}