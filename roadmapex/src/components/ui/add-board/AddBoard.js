import React from 'react';
import { useHistory } from 'react-router-dom';
import './AddBoard.css';
import { processEntity } from "../../../api/api";

export default function AddBoard() {
  const history = useHistory();

  const newCanvas = {
    name: 'Untitled',
    description: 'click to describe'
  };

  const createCanvas = () => {
    processEntity('POST', '/canvas', newCanvas)
        .then(response => response.json())
        .then(canvas => history.push(`canvas/${canvas.id}`))
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