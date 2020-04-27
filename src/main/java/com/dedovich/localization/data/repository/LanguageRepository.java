package com.dedovich.localization.data.repository;

import com.dedovich.localization.data.i18n.generified.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}
