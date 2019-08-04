import React, {Component} from 'react'
import '../menu/Menu.css'


class Menu extends Component {

    state = {
        active: '',
        links: [
            {link: '/', label: 'Home'},

            {link: '/search', label: 'Search'},

            {link: '/login', label: 'Login'},
            {link: '#', label: 'Contact'}
        ]

    }


    render() {
        let links = this.state.links.map((link, index) => {
            return (<li key={index}>< a href={link.link}> {link.label} </a></li>
            )
        })
        return (<>
                <div id="menu">


                    <div className='logo'/>


                    <h1> Library </h1>

                    <ul> {links} </ul>
                </div>


            </>
        )
    }
}

export default Menu