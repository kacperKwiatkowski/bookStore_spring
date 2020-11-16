import axios from "axios";
import React, {useEffect, useState} from "react";
import "./BooksCards.css";

export const BookPosition = () => {

    const [bookPositions, setBookPositions] = useState([]);

    const fetchBookPositions = () => {
        axios.get("http://localhost:8080/books").then(res => {
            console.log(res)
            setBookPositions(res.data)
        });
    }

    useEffect(() => {
        fetchBookPositions();
    }, []);

    return bookPositions.map((bookPosition, index) => {

        return (
            <div key={index}>
                <table className="bookCard">
                    <tbody>
                    <tr>
                        <td>{bookPosition.id ? (
                            <img className="coverImage" src={"http://localhost:8080/books/download/cover/" + bookPosition.id} alt={""}/> ) : null}
                        </td>
                    </tr>
                    <tr>
                        <td>"{bookPosition.title}"</td>
                    </tr>
                    <tr>
                        <td> {bookPosition.author}</td>
                    </tr>
                    <tr>
                        <td>£{bookPosition.price}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    })
}

export default BookPosition
