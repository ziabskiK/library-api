import React from 'react'
import './Login.css'
import axios from 'axios'
import {Button, Form, FormGroup, Input, Label} from 'reactstrap'
import {FacebookLoginButton} from "react-social-login-buttons";

class Login extends React.Component {

    state = {
        email: null,
        password: null
    }


    handleLoginClick = (e) => {
        console.log(this.state.email)
        console.log(this.state.password)

        axios.post("http://localhost:8080/login", this.state).then(res => {
            if (res.status === 200) {
                this.props.history.push('/')
            } else {
                console.log("Error!")
            }
        }).catch()


    }
    handleEmail = (e) => {
        this.setState({email: e.target.value})
    }
    handlePassword = (e) => {
        this.setState({password: e.target.value})
    }


    render() {
        return (


            <Form id='login-form'>
                <h2>Please log in!</h2>
                <FormGroup>
                    <Label>Email</Label>
                    <Input type='email' placeholder='Email'/>
                    <Label>Password</Label>
                    <Input type='password' placeholder='Password'/>
                </FormGroup>
                <Button className='btn-lg btn-dark btn-block'>Log in </Button>
                <div className='text-center pt-3'>Or continue with your social account</div>
                <FacebookLoginButton className='mt-3 mb-3'/>
                <div className='text-center'>

                    <a href="/register">Sign up</a>
                    <span className='p-2'> | </span>
                    <a href="/forgot">Forgot password</a>
                </div>
            </Form>


        )
    }

}

export default Login