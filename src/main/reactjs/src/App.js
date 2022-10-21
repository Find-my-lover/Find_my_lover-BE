import React, {useState, useEffect} from 'react';
//import logo from './logo.svg';
//import './App.css';

import Register from './components/Register';
import Login from './components/Login';
import Layout from './components/Layout';
import { Routes, Route } from 'react-router-dom';

const ROLES = {
  'User': 2001,
  'Editor': 1984,
  'Admin': 5150
}

function App() {
  const [message, setMessage] = useState("");

  useEffect(() =>
  {        fetch('/')
      .then(response => response.text())
      .then(message => {
        setMessage(message);
      });
    },[])

  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        public routes
        <Route path="login" element={<Login />} />
        <Route path="register" element={<Register />} />
      </Route>
    </Routes>
  );
}

export default App;