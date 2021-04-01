package com.nj.njplaygroundspring.personalrecord.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonalRecordChange implements Serializable {

    private static final long serialVersionUID = 4834756086561357618L;

    @Getter
    private String exercise;

    @Getter
    private String setsReps;

    @Getter
    private short record;
}
