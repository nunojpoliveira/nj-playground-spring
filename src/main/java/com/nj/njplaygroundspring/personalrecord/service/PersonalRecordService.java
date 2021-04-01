package com.nj.njplaygroundspring.personalrecord.service;

import com.nj.njplaygroundspring.personalrecord.entities.PersonalRecordEntity;
import com.nj.njplaygroundspring.personalrecord.model.PersonalRecord;
import com.nj.njplaygroundspring.personalrecord.model.PersonalRecordChange;

import java.util.List;

public interface PersonalRecordService {

    List<PersonalRecord> findAll();
    PersonalRecordEntity update(PersonalRecordChange personalRecordChange);
}
