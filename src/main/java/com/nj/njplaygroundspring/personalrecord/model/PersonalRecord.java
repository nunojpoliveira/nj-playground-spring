package com.nj.njplaygroundspring.personalrecord.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@EqualsAndHashCode
public class PersonalRecord {

    @Getter
    private final String exercise;

    @Getter
    private final Map<String, Short> records;
}
