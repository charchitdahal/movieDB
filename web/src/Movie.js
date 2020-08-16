import React, {Component} from 'react';
import AppNav from "./AppNav";
import Genre from "./Genre";
import {Link} from "react-router-dom";
import { Table,Container,Input,Button,Label, FormGroup, Form} from 'reactstrap';

class Movie extends Component{
    state = {

        isLoading :true,
        movies: []

    }

    async componentDidMount(){
        const response= await fetch('/api/genre');
        const body= await response.json();
        this.setState({Genre : body , isLoading :false});
    }

    handleChange

    render() {

        const title=<h2>Add Movie</h2>
        const {Genre,isLoading} = this.state;

        if(isLoading)
            return(<div>Loading....</div>)

        let optionList  =
            Genre.map( (category) =>
                <option value={category.id} key={category.id}>
                    {category.name}
                </option>
            )
        return (

            <div>
                <AppNav/>
                <Container>
                    {title}
                    <Form onSubmit={this.handleChange}>
                        <FormGroup>
                            <label for="title"> Title</label>
                            <input type="text" name="title" id="title" onChange={this.handleChange}/>
                        </FormGroup>

                        <FormGroup>
                            <label for="genre"> Genre</label>
                            <select onChange={this.handleChange}>
                                {optionList}
                            </select>
                        </FormGroup>

                        <FormGroup>
                            <label for="disc"> Description</label>
                            <input type="disc" name="disc" id="disc" onChange={this.handleChange}/>
                        </FormGroup>

                        <FormGroup>
                            <Button color="primary" type="submit"> Save</Button>
                            <Button color="secondary" tag={Link} to="/"> Cancel</Button>
                        </FormGroup>


                    </Form>

                </Container>

            </div>



        );
    }
}
export default Movie;