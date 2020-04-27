package com.dedovich.localization.data.loader;

import com.dedovich.localization.data.i18n.generified.Language;
import com.dedovich.localization.data.i18n.generified.TranslatedText;
import com.dedovich.localization.data.i18n.simplified.TranslatedProduct;
import com.dedovich.localization.data.model.Book;
import com.dedovich.localization.data.model.Product;
import com.dedovich.localization.data.repository.BookRepository;
import com.dedovich.localization.data.repository.LanguageRepository;
import com.dedovich.localization.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final ProductRepository productRepository;
    private final LanguageRepository languageRepository;

    @Override
    public void run(String... args) {
        Language ru = Language.builder().code("ru").build();
        Language en = Language.builder().code("en").build();
        saveLanguages(ru, en);

        saveBook(ru, en);
        saveProduct(ru, en);
    }

    private void saveLanguages(Language ru, Language en) {
        languageRepository.save(ru);
        languageRepository.save(en);
    }

    private void saveProduct(Language ru, Language en) {
        Map<Language, TranslatedProduct> translatedProducts = new HashMap<>();
        Product product = Product.builder()
                .translations(translatedProducts)
                .build();

        translatedProducts.put(ru, TranslatedProduct.builder()
                .name("Имя продукта")
                .description("Описание продукта")
                .language(ru)
                .build());

        translatedProducts.put(en, TranslatedProduct.builder()
                .name("Product name")
                .description("Product description")
                .language(en)
                .build());

        productRepository.save(product);
    }

    private void saveBook(Language ru, Language en) {
        Map<Language, String> authorTranslations = new HashMap<>();
        authorTranslations.put(ru, "Пушкин");
        authorTranslations.put(en, "Pushkin");

        Map<Language, String> nameTranslations = new HashMap<>();
        nameTranslations.put(ru, "Евгений Онегин");
        nameTranslations.put(en, "Eugene Onegin");

        Book book = Book.builder()
                .author(
                        TranslatedText.builder()
                                .translations(authorTranslations)
                                .build()
                )
                .name(
                        TranslatedText.builder()
                                .translations(nameTranslations)
                                .build()
                )
                .build();

        bookRepository.save(book);
    }
}
