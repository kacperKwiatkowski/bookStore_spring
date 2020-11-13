import React from 'react'
import Axios from "axios";
import './AddBookFormStyle.css'

export class AddBookForm extends React.Component {

    constructor(props) {
        super(props);
        this.state = this.initialState
        this.bookChange = this.bookChange.bind(this);
        this.submitBook = this.submitBook.bind(this);
    }

    initialState = {title: '', author: '', price: '', langOfPrint: '', langOfOrigin: '', numOfPages: '', cover: ''};


    submitBook = event => {
        alert("Title: " + this.state.title +
            "Author: " + this.state.author +
            "Price: " + this.state.price +
            "Language of print: " + this.state.langOfPrint +
            "Language of origin: " + this.state.langOfOrigin +
            "numOfPages: " + this.state.numOfPages +
            "Book cover URL: " + this.state.cover)
        event.preventDefault()

        const book = {
            title: this.state.title,
            author: this.state.author,
            price: this.state.price,
            langOfPrint: this.state.langOfPrint,
            langOfOrigin: this.state.langOfOrigin,
            numOfPages: this.state.numOfPages
        };

        Axios.post("http://localhost:8080/books", book)
            .then(response => {
                if(response.data != null) {
                    this.setState(this.initialState);
                    alert("Book added successfully")
                }
            })
    }
    resetBook = () => {
        this.setState(() => this.initialState)
    }

    bookChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render() {
        const {title, author, price, langOfPrint, langOfOrigin, numOfPages, cover} = this.state

        return (

            <div className="addBookFormWrapper">
                <form onReset={this.resetBook} onSubmit={this.submitBook} id="addBook">
                    <label>Title
                        <input required autoComplete="off" type="text" name="title" id="addBookTitle"
                               value={title}
                               onChange={this.bookChange}/>
                    </label>
                    <label>Author
                        <input required autoComplete="off" type="text" name="author" id="addBookAuthor"
                               value={author}
                               onChange={this.bookChange}/></label>
                    <label>Price
                        <input required autoComplete="off" type="text" name="price" id="addBookPrice"
                               value={price}
                               onChange={this.bookChange}/></label>
                    <label>LangOfPrint
                        <input required autoComplete="off" type="text" name="langOfPrint" id="addBookLangOfPrint"
                               value={langOfPrint}
                               onChange={this.bookChange}/></label>
                    <label>LangOfOrigin
                        <input required autoComplete="off" type="text" name="langOfOrigin" id="addBookLangOfOrigin"
                               value={langOfOrigin}
                               onChange={this.bookChange}/></label>
                    <label>NumOfPages
                        <input required autoComplete="off" type="text" name="numOfPages" id="addBookNumOfPages"
                               value={numOfPages}
                               onChange={this.bookChange}/></label>
                    <label>Cover
                        <input required autoComplete="off" type="file" name="cover" id="addBookCover"
                               value={cover}
                               onChange={this.bookChange}/></label>
                    <button type="submit">SUBMIT</button>
                    <button type="reset">RESET</button>
                </form>
            </div>
        )
    }

}

export default AddBookForm