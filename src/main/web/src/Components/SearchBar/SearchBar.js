import React from 'react';
import './SearchBar.css';

export class SearchBar extends React.Component {
    render() {
        return(
            <form>
                <input type="text" className="searchBar"/>
                <button type={"submit"} className="searchButton">Search  <i className="fas fa-search"/> </button>
            </form>
        )
    }

}