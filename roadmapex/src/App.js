import React from 'react';
import './App.css';
import Header from './components/ui/header/Header.js';
import CanvasStateProvider from './components/wrappers/CanvasStateProvider.js';

function App() {
  return (
    <div className="App">
      <div className="App-continer">
        <Header />
        <CanvasStateProvider />
        <section className="comments">
          Comments section
        </section>
      </div>
    </div>
  );
}

export default App;
