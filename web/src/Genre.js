import React, {Component} from "react";
import AppNav from "./AppNav";
import {Button, Container, Form, FormGroup} from "reactstrap";
import {Link} from "react-router-dom";

class Genre extends Component{



    state = {
        isLoading : true,
        Genre : []
    }

    //sync, send a req and wait

    //async, send a req and no wait
    async componentDidMount(){
        const response = await fetch('/api/genre');
        const body = await response.json();
        this.setState({Genre: body, isLoading: false});
    }

    async handleSubmit(event){
        const item = this.state.item;
        await fetch(`/api/genre`, {
            method : 'POST',
            headers : {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body : JSON.stringify(item),
        });

        event.preventDefault();
        this.props.history.push("/genre");
    }

    render(){

        const title=<h2>Add Genre</h2>


        const {Genre, isLoading} = this.state;
        if(isLoading)
            return (<div>Loading....</div>);
        else
            return (
            <div>
                <AppNav/>
                <Container>
                    {title}


                    <FormGroup>
                        <label for="disc"> Genre Name</label>

                        <input type="disc" name="disc" id="disc" onChange={this.handleChange}/>
                    </FormGroup>

                    <FormGroup>
                        <Button color="primary" type="submit" onClick={()=> this.remove(Genre.id)}> Save</Button>
                        <Button color="secondary" tag={Link} to="/"> Cancel</Button>
                    </FormGroup>

                {



                    Genre.map( genre =>
                        <div id={genre.id}>
                            {genre.name}

                        </div>

                    )
                }
                </Container>

            </div>

        );
    }

}
export default Genre;