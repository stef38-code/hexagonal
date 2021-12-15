package org.stephane.output.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.stephane.output.entities.AdresseEntity;

@Repository
@Qualifier("AdresseEntityRepository")
public interface AdresseEntityRepository extends JpaRepository<AdresseEntity, String> {
}
