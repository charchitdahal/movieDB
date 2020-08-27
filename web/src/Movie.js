import React, {Component} from 'react';
import AppNav from "./AppNav";
import {Link} from "react-router-dom";
import { Table,Container,Input,Button,Label, FormGroup, Form} from 'reactstrap';

/**
 *
 * Functions within Movie.js
 *
 * @handleSubmit
 * @handleChange
 * @remove
 * @componentDidMount
 * @render
 *
 */

class Movie extends Component{
    emptyItem={
        id: '105',
        name: '',
        description: '',
        genre: ''}


    constructor(props) {
        super(props);

        this.state = {
            isLoading :true,
            genre: [],
            movies: [],
            item: this.emptyItem
        }
        this.handleSubmit= this.handleSubmit.bind(this);
        this.handleChange= this.handleChange.bind(this);

    }

// prop that you'd pass to onSubmit
// mid layer for forms' submit handler.
    async handleSubmit(event){

        const item = this.state.item;
        await fetch(`/api/movie`, {
            method : 'POST',
            headers : {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body : JSON.stringify(item),
        });

        event.preventDefault();
        this.props.history.push("/movie");
    }


// mid layer for forms' onChange handler.
    handleChange(event){
        const target= event.target;
        const value= target.value;
        const name = target.name;
        let item={...this.state.item};
        item[name] = value;
        this.setState({item});

    }
    //calls in DELETE API passing method and headers as JSON
    async remove(id){
        await fetch(`/api/movie/${id}` , {
            method: 'DELETE' ,
            headers : {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            }

        }).then(() => {
            let updatedExpenses = [...this.state.Movie].filter(i => i.id !== id);
            this.setState({Movie : updatedExpenses});
        });

    }

    async componentDidMount(){


        const response= await fetch('/api/movie');
        const body= await response.json();
        this.setState({Movie : body , isLoading :false});
    }


    render() {



        const title=<h2>Add Movie</h2>
        const {Genre} = this.state;
        const {Movie,isLoading} = this.state;

        if(isLoading)
            return(<div>Loading....</div>)


        let rows=
            Movie.map( movie =>
                <tr key={movie.id}>
                    <td>{movie.name}</td>
                    <td>{movie.description}</td>
                    <td>{movie.genre}</td>

                    <td><Button size="sm" color="danger" onClick={() => this.remove(movie.id)}>Delete</Button></td>

                </tr>

            );


        return (
            <div>
                <AppNav/>


                <Container >
                    {title}
                    <hr/>
                    <Form onSubmit={this.handleSubmit} >
                        <FormGroup>
                            <label for="name"> Title</label>
                            <input type="name" name="name" id="name" onChange={this.handleChange} autoComplete="name"/>
                        </FormGroup>

                        <FormGroup>
                            <label for="genre"> Genre</label>
                            <input type="genre" name="genre" id="genre" onChange={this.handleChange}/>
                        </FormGroup>


                        <FormGroup>
                            <label for="description"> Description</label>
                            <input type="description" name="description" id="description" onChange={this.handleChange}/>
                        </FormGroup>

                        <FormGroup>
                            <Button color="primary" type="submit">Save</Button>{' '}
                            <Button color="secondary" tag={Link} to="/"> Cancel</Button>
                        </FormGroup>


                    </Form>

                </Container>

                {''}
                <Container>
                    <h3>Movies List</h3>
                    <Table className="my-4">
                        <thead>
                        <tr>
                            <th width="20%"> Name  </th>
                        <th width="20%"> Description   </th>
                        <th width="20%"> Genre  </th>

                           < th width="20%"> Action  </th>
                        </tr>
                        </thead>

                        <tbody>
                        {rows}
                        </tbody>

                    </Table>
                </Container>
                }
            </div>



        );
    }
}
export default Movie;