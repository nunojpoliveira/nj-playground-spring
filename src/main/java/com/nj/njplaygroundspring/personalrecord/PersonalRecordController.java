package com.nj.njplaygroundspring.personalrecord;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personalrecords")
public class PersonalRecordController {

    @GetMapping
    public List<PersonalRecord> getAll() {
        final Map<String, Short> deadliftRecords = new HashMap<>();
        deadliftRecords.put("3x12", (short)50);
        deadliftRecords.put("3x10", (short)60);
        deadliftRecords.put("5x5", (short)75);

        final Map<String, Short> benchPressRecords = new HashMap<>();
        deadliftRecords.put("3x12", (short)25);
        deadliftRecords.put("5x5", (short)50);

        final Map<String, Short> bentOverBarbellRowRecords = new HashMap<>();
        bentOverBarbellRowRecords.put("3x12", (short)50);
        bentOverBarbellRowRecords.put("3x10", (short)55);

        return Arrays.asList(
                new PersonalRecord("Deadlift", deadliftRecords),
                new PersonalRecord("Bench Press", benchPressRecords),
                new PersonalRecord("Bent Over Barbell Row", bentOverBarbellRowRecords)
        );
    }
}
