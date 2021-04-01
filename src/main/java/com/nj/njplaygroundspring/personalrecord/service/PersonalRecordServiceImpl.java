package com.nj.njplaygroundspring.personalrecord.service;

import com.nj.njplaygroundspring.personalrecord.entities.PersonalRecordEntity;
import com.nj.njplaygroundspring.personalrecord.entities.PersonalRecordIdentity;
import com.nj.njplaygroundspring.personalrecord.model.PersonalRecord;
import com.nj.njplaygroundspring.personalrecord.model.PersonalRecordChange;
import com.nj.njplaygroundspring.personalrecord.repository.PersonalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonalRecordServiceImpl implements PersonalRecordService {

    private final PersonalRecordRepository repository;

    public PersonalRecordServiceImpl(PersonalRecordRepository repository) {
        this.repository = repository;
    }

    public List<PersonalRecord> findAll() {
        List<PersonalRecordEntity> personalRecordEntities = repository.findAll();
        List<PersonalRecord> personalRecords = new ArrayList<>();

        for (PersonalRecordEntity personalRecordEntity: personalRecordEntities) {
            PersonalRecord exercisePersonalRecord = personalRecords.stream().filter(pr -> pr.getExercise()
                    .equals(personalRecordEntity.getPersonalRecordIdentity().getExercise())).findFirst().orElse(null);
            if (exercisePersonalRecord != null) {
                exercisePersonalRecord.getRecords().put(
                        personalRecordEntity.getPersonalRecordIdentity().getSetsReps(),
                        personalRecordEntity.getRecord());
            }
            else {
                Map<String, Short> records = new HashMap<>();
                records.put(personalRecordEntity.getPersonalRecordIdentity().getSetsReps(),
                        personalRecordEntity.getRecord());
                PersonalRecord personalRecord =
                        new PersonalRecord(personalRecordEntity.getPersonalRecordIdentity().getExercise(), records);
                personalRecords.add(personalRecord);
            }
        }
        return personalRecords;
    }

    public PersonalRecordEntity update(PersonalRecordChange personalRecordChange) {
        return repository.save(new PersonalRecordEntity(new PersonalRecordIdentity(
                personalRecordChange.getExercise(),
                personalRecordChange.getSetsReps()),
                personalRecordChange.getRecord()));
    }
}
