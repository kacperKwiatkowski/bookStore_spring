import React, {Component} from 'react';
import Axios from 'axios';

class test extends Component {

    fileSelectHandler = event => {
        this.setState({selectedFile: event.target.files[0]})
    }

    fileUploadHandler = () => {
        const fd = new FormData();
        fd.append('file',
            this.state.selectedFile,
            this.state.selectedFile.name);

        console.log(this.state.selectedFile)
        console.log(fd.get("file"))
        Axios.post("http://localhost:8080/books/upload", fd)
            .then(res => {
                console.log(res)
            });
    }


    render() {
        return (<div className="Test">
            <input type="file" onChange={this.fileSelectHandler}/>
            <button onClick={this.fileUploadHandler}>upload</button>
        </div>)
    }
}
export default test