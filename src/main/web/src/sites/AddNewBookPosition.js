import React from 'react'
import './AddBookFormStyle.css'

export class AddBookForm extends React.Component {
    render() {
        return (

            <div className="addBookFormWrapper">
                <form>
                    <label>Title
                        <input type="text"></input>
                    </label>
                    <label>Author
                        <input type="text"></input></label>
                    <label>Price
                        <input type="text"></input></label>
                    <label>LangOfPrint
                        <input type="text"></input></label>
                    <label>LangOfOrigin
                        <input type="text"></input></label>
                    <label>NumOfPages
                        <input type="text"></input></label>
                    <label>Price
                        <input type="text"></input></label>
                    <label>Cover
                        <input type="file"></input></label>
                </form>
            </div>
        )
    }

}

export default AddBookForm