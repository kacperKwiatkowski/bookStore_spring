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

    return bookPositions.map((userProfile, index) => {

        return (
            <div key={index}>
                <table className="bookCard">
                    <tr>
                        <td>Title:</td>
                        <td>"{userProfile.title}"</td>
                    </tr>
                    <tr>
                        <td>Author:</td>
                        <td> {userProfile.author}</td>
                    </tr>
                    <tr>
                        <td>Number of pages:</td>
                        <td>{userProfile.numOfPages}</td>
                    </tr>
                    <tr>
                        <td>Print language:</td>
                        <td>{userProfile.langOfPrint}</td>
                    </tr>
                    <tr>
                        <td>Original language:</td>
                        <td>{userProfile.langOfOrigin}</td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td>{userProfile.price}</td>
                    </tr>
                    <tr>
                        <td>Amount in stock:</td>
                        <td>{userProfile.amountInStock}</td>
                    </tr>

                </table>
            </div>
        )
    })
}

export default BookPosition
