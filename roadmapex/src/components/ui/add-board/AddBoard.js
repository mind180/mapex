import React, {useState} from 'react';
import './AddBoard.css';

export default function AddBoard() {
  return (
    <div
      className='add-board'
      onClick={e => console.log('on click')}
    >
      <div className="add-board__shadow">
        <div className="add-board__plus">+</div>
        <div className="add-board__title">New</div>
      </div>
    </div>
  );
}