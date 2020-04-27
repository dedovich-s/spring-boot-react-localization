import React, {useState} from 'react';
import './App.css';
import {useTranslation} from 'react-i18next';

function App() {
    const [language, setLanguage] = useState('en');
    const {t, i18n} = useTranslation();

    function handleLanguageChange(language) {
        i18n.changeLanguage(language).then(() => setLanguage(language));
    }

    return (
        <div className="App">
            <button onClick={() => handleLanguageChange('en')}>en</button>
            <button onClick={() => handleLanguageChange('ru')}>ru</button>
            <p>{t("currentLanguage")}</p>

            <h1>{t("helloWorld")}</h1>

            <h2>{t("books")}</h2>

            <h2>{t("products")}</h2>
        </div>
    );
};

export default App;
