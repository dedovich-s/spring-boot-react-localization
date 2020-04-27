package com.dedovich.localization.data.i18n.generified;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Map;

@Builder
@Data
@Entity
@Table(name = "i18n_key")
public class TranslatedText {
    @GeneratedValue
    @Id
    private Long id;

    @Cascade( CascadeType.ALL )
    @ElementCollection( targetClass = java.lang.String.class, fetch = FetchType.EAGER )
    @MapKeyJoinColumn( name = "language_id" )
    @CollectionTable( name = "translation", joinColumns = @JoinColumn( name = "i18n_key" ) )
    @Column( name = "text" )
    private Map<Language, String> translations;
}
