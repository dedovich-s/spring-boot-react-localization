package com.dedovich.localization.data.i18n.simplified;

import com.dedovich.localization.data.i18n.generified.Language;
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
@Table(name = "translated_product")
public class TranslatedProduct {
    @GeneratedValue
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "language_id")
    private Language language;

    private String name;

    private String description;
}
