package com.nj.njplaygroundspring.personalrecord;

import com.nj.njplaygroundspring.personalrecord.model.PersonalRecord;
import com.nj.njplaygroundspring.personalrecord.model.PersonalRecordChange;
import com.nj.njplaygroundspring.personalrecord.service.PersonalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personalrecords")
public class PersonalRecordController {

    @Autowired
    PersonalRecordService personalRecordService;

    @GetMapping
    public List<PersonalRecord> getAll() {
        return personalRecordService.findAll();
    }

    @PostMapping
    public List<PersonalRecord> update(@RequestBody PersonalRecordChange personalRecordChange) {
        personalRecordService.update(personalRecordChange);
        return personalRecordService.findAll();
    }
}
