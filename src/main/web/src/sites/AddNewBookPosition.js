import React from 'react'
import Axios from "axios";
import './AddBookFormStyle.css'

export class AddBookForm extends React.Component {

    constructor(props) {
        super(props);
        this.state = this.initialState
        this.bookDetailsChange = this.bookDetailsChange.bind(this);
        this.bookCoverChange = this.bookCoverChange.bind(this);
        this.submitBook = this.submitBook.bind(this);
    }

    initialState = {title: '', author: '', price: '', langOfPrint: '', langOfOrigin: '', numOfPages: ''};

    submitBook = (event) => {
        event.preventDefault()

        let book = {
            title: this.state.title,
            author: this.state.author,
            price: this.state.price,
            langOfPrint: this.state.langOfPrint,
            langOfOrigin: this.state.langOfOrigin,
            numOfPages: this.state.numOfPages,
        };

        const formData = new FormData();
        formData.append('image', this.state.cover);
        formData.append('details', book);

        Axios.post("http://localhost:8080/books/upload", formData, {
                headers: {
                    "Content-Type": "multipart/form-data"
                }
            }
        )
            .then(response => {
                if (response.data != null) {
                    this.setState(this.initialState);
                    alert("Book added successfully")
                }
            })
    }

    resetBook = () => {
        this.setState(() => this.initialState)
    }

    bookDetailsChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    bookCoverChange = event => {
        this.setState({
            cover: event.target.files[0]
        })
    }

    render() {
        const {title, author, price, langOfPrint, langOfOrigin, numOfPages} = this.state

        return (

            <div className="addBookFormWrapper">
                <form onReset={this.resetBook} onSubmit={this.submitBook} id="addBook">
                    <label>Title
                        <input required autoComplete="off" type="text" name="title" id="addBookTitle"
                               value={title}
                               onChange={this.bookDetailsChange}/>
                    </label>
                    <label>Author
                        <input required autoComplete="off" type="text" name="author" id="addBookAuthor"
                               value={author}
                               onChange={this.bookDetailsChange}/></label>
                    <label>Price
                        <input required autoComplete="off" type="text" name="price" id="addBookPrice"
                               value={price}
                               onChange={this.bookDetailsChange}/></label>
                    <label>LangOfPrint
                        <input required autoComplete="off" type="text" name="langOfPrint" id="addBookLangOfPrint"
                               value={langOfPrint}
                               onChange={this.bookDetailsChange}/></label>
                    <label>LangOfOrigin
                        <input required autoComplete="off" type="text" name="langOfOrigin" id="addBookLangOfOrigin"
                               value={langOfOrigin}
                               onChange={this.bookDetailsChange}/></label>
                    <label>NumOfPages
                        <input required autoComplete="off" type="text" name="numOfPages" id="addBookNumOfPages"
                               value={numOfPages}
                               onChange={this.bookDetailsChange}/></label>
                    <label>Cover
                        <input required autoComplete="off" type="file" name="cover" id="addBookCover"
                               onChange={this.bookCoverChange}
                               onClick={this.fileSelectHandler}/></label>
                    <button type="submit">SUBMIT</button>
                    <button type="reset">RESET</button>
                </form>
            </div>
        )
    }
}

export default AddBookForm