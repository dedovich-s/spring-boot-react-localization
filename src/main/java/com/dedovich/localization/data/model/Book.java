package com.dedovich.localization.data.model;

import com.dedovich.localization.data.i18n.generified.TranslatedText;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "book")
public class Book {
    @GeneratedValue
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_i18n_key")
    private TranslatedText name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_i18n_key")
    private TranslatedText author;
}
