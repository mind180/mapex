import React from 'react';
import './App.css';
import Header from './components/ui/header/Header.js';
import CanvasStateProvider from './components/wrappers/CanvasStateProvider.js';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import ProfileHeader from './components/ui/profile-header/ProfileHeader.js'

function App() {
  return (
    <div className="App">
      <Router>
        <Header />
        <Switch>
          <Route path="/library">
            <div>library</div>
          </Route>
          <Route path="/user">
            <ProfileHeader />
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
