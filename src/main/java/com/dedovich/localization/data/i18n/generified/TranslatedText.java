package com.dedovich.localization.data.i18n.generified;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "i18n_key")
public class TranslatedText {
    @GeneratedValue
    @Id
    private Long id;

    private String defaultValue;

    @Cascade(CascadeType.ALL)
    @ElementCollection(targetClass = java.lang.String.class, fetch = FetchType.EAGER)
    @MapKeyJoinColumn(name = "language_id")
    @CollectionTable(name = "translation", joinColumns = @JoinColumn(name = "i18n_key"))
    @Column(name = "text")
    private Map<Language, String> translations;

    /**
     * Just for demo. Use DTO mapping for prod
     */
    public Map<String, String> getTranslations() {
        return translations.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().getCode(), Map.Entry::getValue));
    }
}
