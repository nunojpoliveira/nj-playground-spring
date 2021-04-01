package com.nj.njplaygroundspring.personalrecord.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PersonalRecordIdentity implements Serializable {

    private static final long serialVersionUID = 6771955270912941144L;

    @Getter
    @Setter
    private String exercise;

    @Getter
    @Setter
    private String setsReps;
}
