package com.nj.njplaygroundspring.personalrecord.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name= "personal_records")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PersonalRecordEntity implements Serializable {

    private static final long serialVersionUID = 2011304373361261326L;

    @EmbeddedId
    @Getter
    private PersonalRecordIdentity personalRecordIdentity;

    @Column(name = "record")
    @Getter
    private short record;
}
