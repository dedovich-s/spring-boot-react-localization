package com.dedovich.localization.data.i18n.generified;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@Entity
@Table(name = "language")
public class Language {
    @GeneratedValue
    @Id
    private Long id;

    private String code;
}
