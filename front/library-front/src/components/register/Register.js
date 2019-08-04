import React, {Component} from 'react'
import {Button, Form, FormGroup, Input, Label} from "reactstrap";
import './Register.css'

class Register extends Component {

    render() {
        return (

            <Form id='login-form'>

                <h2>Please sign up!</h2>
                <FormGroup>
                    <Label>Email</Label>
                    <Input type='email' placeholder='Email'/>

                    <Label>First name</Label>
                    <Input type='text' placeholder='First name'/>
                    <Label>Last name</Label>
                    <Input type='text' placeholder='Last name'/>
                    <Label>Password</Label>
                    <Input type='password' placeholder='Password'/>
                </FormGroup>
                <Button className='btn-lg btn-dark btn-block'>Sign up</Button>
                <div className='text-center pt-3'>Already have an account? Please log in</div>

                <div className='text-center'>

                    <a href='/login'>Log in here</a>
                </div>
            </Form>
        )
    }

}

export default Register