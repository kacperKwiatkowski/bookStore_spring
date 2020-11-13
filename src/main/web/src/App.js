import './App.css';
import {Header} from "./components/Header";
import BookPosition from "./components/BooksCards";
import AddBookForm from "./sites/AddNewBookPosition";



function App() {
    return (
        <div className="App">
            <Header />
            <BookPosition />
            <AddBookForm />
        </div>
    );
}

export default App;
