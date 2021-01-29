import React from 'react';
import './App.css';
import Header from './components/ui/header/Header.js';
import CanvasStateProvider from './components/wrappers/CanvasStateProvider.js';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import ProfileHeader from './components/ui/profile-header/ProfileHeader.js';
import Dashboard from "./components/ui/dashboard/Dashboard";
import Board from "./components/ui/board/Board";

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
          <Route path="/canvas/:canvasId">
            <Board/>
          </Route>
          <Route path="/">
            <CanvasStateProvider canvasId='5494c80e-c617-4120-b0a5-0a99be0df8ca'  />
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
