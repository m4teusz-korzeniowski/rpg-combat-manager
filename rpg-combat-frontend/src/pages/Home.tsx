import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import React from "react";

function Home() {
    return (
        <div className="container mb-3 p-1 my-1 bg-light rounded shadow-sm">
            <h1>RPG Combat Manager</h1>
            <p>Wybierz opcję:</p>
            <div className="mb-2">
                <Link to="/skills">
                    <Button variant="primary">Baza umiejętności</Button>
                </Link>
            </div>
            <div>
                <Link to="/Units">
                    <Button variant="primary">Baza jednostek</Button>
                </Link>
            </div>

        </div>
    );
}

export default Home;