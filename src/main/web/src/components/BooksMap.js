
import axios from "axios";
import React, {useEffect, useState} from "react";

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
                <h7>Title: "{userProfile.title}"</h7>
                <h7>Author: {userProfile.author}</h7>
                <h7>Number of pages: {userProfile.numOfPages}</h7>
                <h7>Print language: {userProfile.langOfPrint}</h7>
                <h7>Original language: {userProfile.langOfOrigin}</h7>
                <h7>Price: {userProfile.price}</h7>
                <h7>Amount in stock: {userProfile.amountInStock}</h7>
            </div>
        )
    })
}

export default BookPosition
