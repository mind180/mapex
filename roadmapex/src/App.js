import React from 'react';
import './App.css';
import Header from './components/ui/header/Header.js';
import CanvasStateProvider from './components/wrappers/CanvasStateProvider.js';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import ProfileHeader from './components/ui/profile-header/ProfileHeader.js';
import Dashboard from "./components/ui/dashboard/Dashboard";

function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <Switch>
          <Route path="/library">
            <Dashboard />
          </Route>
          <Route path="/user">
            <ProfileHeader />
            <Dashboard />
          </Route>
          <Route path="/">
            <CanvasStateProvider />
            <section className="comments">
              Comments section
            </section>
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
