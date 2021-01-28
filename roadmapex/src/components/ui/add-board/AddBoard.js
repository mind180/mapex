import React from 'react';
import './AddBoard.css';

export default function AddBoard() {
  const createBoard = () => {
    console.log('click');
  };

  return (
    <div className='add-board'
      onClick={createBoard}
    >
      <div className="add-board__shadow">
        <div className="add-board__plus">+</div>
        <div className="add-board__title">New</div>
      </div>
    </div>
  );
}