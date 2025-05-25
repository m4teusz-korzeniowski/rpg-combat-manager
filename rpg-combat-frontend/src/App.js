import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './pages/Home';
import Skills from './pages/Skills';
import AddSkill from "./pages/AddSkill";
import EditSkill from "./pages/EditSkill";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/skills" element={<Skills/>}/>
                <Route path="/skills/add" element={<AddSkill/>}/>
                <Route path="/skills/edit/:id" element={<EditSkill/>}/>
            </Routes>
        </Router>
    );
}

export default App;