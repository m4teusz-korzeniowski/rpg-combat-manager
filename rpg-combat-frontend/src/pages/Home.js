import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';

function Home() {
    return (
        <div className='p-3'>
            <h1>RPG Combat Manager</h1>
            <p>Wybierz opcję:</p>
            <Link to="/skills">
                <Button variant="primary">Baza umiejętności</Button>
            </Link>
        </div>
    );
}

export default Home;