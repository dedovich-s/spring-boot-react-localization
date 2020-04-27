import React, {useEffect, useState} from 'react';
import './App.css';
import {useTranslation} from 'react-i18next';
import axios from 'axios';
import {BOOKS_URL, PRODUCTS_URL} from "./constants/constants";
import {Book} from "./components/Book";
import {Product} from "./components/Product";

function App() {
    const [language, setLanguage] = useState('en');
    const [books, setBooks] = useState([]);
    const [products, setProducts] = useState([]);
    const {t, i18n} = useTranslation();

    useEffect(() => {
        axios.get(PRODUCTS_URL)
            .then(response => {
                setProducts(response.data._embedded.products);
            })
            .catch(console.log);
    }, []);

    useEffect(() => {
        axios.get(BOOKS_URL)
            .then(response => {
                setBooks(response.data._embedded.books);
            })
            .catch(console.log);
    }, []);

    function handleLanguageChange(newLanguage) {
        i18n.changeLanguage(newLanguage).then(() => setLanguage(newLanguage));
    }

    return (
        <div className="App">
            <button onClick={() => handleLanguageChange('en')}>en</button>
            <button onClick={() => handleLanguageChange('ru')}>ru</button>
            <p>{t("currentLanguage")}</p>

            <h1>{t("helloWorld")}</h1>

            <h2>{t("books")}</h2>
            {books.map(book => <Book key={book.id} name={book.name.translations[language]} author={book.author.translations[language]}/>)}

            <h2>{t("products")}</h2>
            {products.map(product => <Product key={product.id} name={product.translations[language].name} description={product.translations[language].description}/>)}
        </div>
    );
}

export default App;
