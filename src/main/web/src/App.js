import React from 'react'
import './App.css';
import {HeaderBar} from "./components/HeaderBar/HeaderBar";
import {HeaderNav} from "./components/HeaderNav/HeaderNav";
import BookPosition from "./components/Body/BooksCards";
import AddBookForm from "./utilities/AddNewBookPosition";

function App() {
    return (
        <div className="App">
                <HeaderBar/>
                <HeaderNav/>
                <div className="all">

                    <div className="bodyWrapper">
                        <BookPosition/>{/*
                        <AddBookForm/>*/}
                    </div>
                </div>
        </div>
    )
}
export default App;
