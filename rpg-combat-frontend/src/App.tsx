import React, {JSX} from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './pages/Home';
import Skills from './pages/skills/Skills';
import AddSkill from "./pages/skills/AddSkill";
import EditSkill from "./pages/skills/EditSkill";
import Units from "./pages/Units";

function App(): JSX.Element {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/skills" element={<Skills/>}/>
                <Route path="/skills/add" element={<AddSkill/>}/>
                <Route path="/skills/edit/:id" element={<EditSkill/>}/>

                <Route path="/units" element={<Units/>}/>
            </Routes>
        </Router>
    );
}

export default App;
