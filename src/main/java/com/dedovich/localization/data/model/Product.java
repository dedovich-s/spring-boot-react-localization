package com.dedovich.localization.data.model;

import com.dedovich.localization.data.i18n.generified.Language;
import com.dedovich.localization.data.i18n.simplified.TranslatedProduct;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Builder
@Data
@Entity
@Table(name = "product")
public class Product {
    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @MapKey(name = "language")
    private Map<Language, TranslatedProduct> translations;
}
