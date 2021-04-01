package com.nj.njplaygroundspring.personalrecord.service;

import com.nj.njplaygroundspring.personalrecord.entities.PersonalRecordEntity;
import com.nj.njplaygroundspring.personalrecord.entities.PersonalRecordIdentity;
import com.nj.njplaygroundspring.personalrecord.model.PersonalRecord;
import com.nj.njplaygroundspring.personalrecord.model.PersonalRecordChange;
import com.nj.njplaygroundspring.personalrecord.repository.PersonalRecordRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PersonalRecordServiceImplTest {

    @Mock
    PersonalRecordRepository repository;

    @InjectMocks
    private PersonalRecordServiceImpl service;

    @Test
    void getAll() {
        List<PersonalRecordEntity> personalRecordEntities = Arrays.asList(
                new PersonalRecordEntity(new PersonalRecordIdentity("exercise1", "3x10"), (short) 30),
                new PersonalRecordEntity(new PersonalRecordIdentity("exercise1", "3x12"), (short) 25),
                new PersonalRecordEntity(new PersonalRecordIdentity("exercise1", "5x5"), (short) 50),
                new PersonalRecordEntity(new PersonalRecordIdentity("exercise2", "3x10"), (short) 40),
                new PersonalRecordEntity(new PersonalRecordIdentity("exercise2", "3x12"), (short) 35),
                new PersonalRecordEntity(new PersonalRecordIdentity("exercise3", "5x5"), (short) 60)
        );

        Map<String, Short> exercise1Records = new HashMap<>();
        exercise1Records.put("3x10", (short) 30);
        exercise1Records.put("3x12", (short) 25);
        exercise1Records.put("5x5", (short) 50);

        Map<String, Short> exercise2Records = new HashMap<>();
        exercise2Records.put("3x10", (short) 40);
        exercise2Records.put("3x12", (short) 35);

        Map<String, Short> exercise3Records = new HashMap<>();
        exercise3Records.put("5x5", (short) 60);

        List<PersonalRecord> expectedResponse = Arrays.asList(
                new PersonalRecord("exercise1", exercise1Records),
                new PersonalRecord("exercise2", exercise2Records),
                new PersonalRecord("exercise3", exercise3Records)
        );

        given(repository.findAll()).willReturn(personalRecordEntities);

        assertThat(service.findAll()).isEqualTo(expectedResponse);
    }

    @Test
    void update() {
        PersonalRecordChange change = new PersonalRecordChange("exercise1", "3x12", (short) 45);

        PersonalRecordEntity entity = new PersonalRecordEntity(new PersonalRecordIdentity("exercise1", "3x12"), (short) 45);
        given(repository.save(entity)).willReturn(entity);

        assertThat(service.update(change)).isEqualTo(entity);
    }
}
