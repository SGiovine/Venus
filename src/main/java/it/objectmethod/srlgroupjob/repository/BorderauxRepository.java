package it.objectmethod.srlgroupjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.srlgroupjob.entities.BorderauxEntity;

@Repository
public interface BorderauxRepository extends JpaRepository<BorderauxEntity, Long> {

	
}
