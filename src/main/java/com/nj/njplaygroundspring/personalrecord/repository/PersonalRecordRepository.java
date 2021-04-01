package com.nj.njplaygroundspring.personalrecord.repository;

import com.nj.njplaygroundspring.personalrecord.entities.PersonalRecordEntity;
import com.nj.njplaygroundspring.personalrecord.entities.PersonalRecordIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRecordRepository extends JpaRepository<PersonalRecordEntity, PersonalRecordIdentity> {
}
