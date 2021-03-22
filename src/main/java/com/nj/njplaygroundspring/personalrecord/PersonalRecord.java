package com.nj.njplaygroundspring.personalrecord;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
public class PersonalRecord {

    @Getter
    private final String exercise;

    @Getter
    private final Map<String, Short> records;
}
