import React, {useState} from 'react';
import './AddBoard.css';
import { processEntity } from "../../../api/api";

export default function AddBoard() {
  const newCanvas = {
    name: 'Untitled',
    description: ''
  };

  const createCanvas = () => {
    processEntity('POST', '/canvas', newCanvas)
        .then(canvas => console.log(canvas))
        .catch(error => console.error(error));
  };

  return (
    <div
      className='add-board'
      onClick={createCanvas}
    >
      <div className="add-board__shadow">
        <div className="add-board__plus">+</div>
        <div className="add-board__title">New</div>
      </div>
    </div>
  );
}