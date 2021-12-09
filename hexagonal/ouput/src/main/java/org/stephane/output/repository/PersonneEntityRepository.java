package org.stephane.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stephane.output.entities.PersonneEntity;

@Repository
public interface PersonneEntityRepository extends JpaRepository<PersonneEntity, String> {
}
