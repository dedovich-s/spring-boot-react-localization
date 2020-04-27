package com.dedovich.localization.data.model;

import com.dedovich.localization.data.i18n.generified.Language;
import com.dedovich.localization.data.i18n.simplified.TranslatedProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "product")
public class Product {
    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @MapKey(name = "language")
    private Map<Language, TranslatedProduct> translations;

    /**
     * Just for demo. Use DTO mapping for prod
     */
    public Map<String, TranslatedProduct> getTranslations() {
        return translations.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().getCode(), Map.Entry::getValue));
    }
}
