import { Link } from 'react-router-dom';

function Home() {
    return (
        <div style={{ padding: '2rem', fontFamily: 'sans-serif' }}>
            <h1>RPG Combat</h1>
            <p>Witaj w grze RPG. Wybierz opcję:</p>
            <Link to="/skills">
                <button>Przejdź do umiejętności</button>
            </Link>
        </div>
    );
}

export default Home;