import i18n from "i18next";

// when like to detect user language and load translation
// npm install i18next-http-backend i18next-browser-languagedetector --save

i18n.init({
    resources: {
        en: {
            translations: {
                currentLanguage: "Current language: English",
                helloWorld: "Hello, world!",
                books: "Books:",
                products: "Products:"
            }
        },
        ru: {
            translations: {
                currentLanguage: "Текущий язык: Русский",
                helloWorld: "Привет, мир!",
                books: "Книги:",
                products: "Продукты:"
            }
        }
    },
    fallbackLng: "en",
    debug: true,

    // have a common namespace used around the full app
    ns: ["translations"],
    defaultNS: "translations",

    keySeparator: false, // we use content as keys

    interpolation: {
        escapeValue: false, // not needed for react!!
        formatSeparator: ","
    },

    react: {
        wait: true
    }
});

export default i18n;