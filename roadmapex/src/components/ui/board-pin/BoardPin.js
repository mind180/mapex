import React from 'react';
import './BoardPin.css'
import { useHistory } from 'react-router-dom';

export default function BoardPin(props) {
  const {id: canvasId, title, description} = props;
  const history = useHistory();

  const redirectToBoard = () => {
    history.push(`/canvas/${canvasId}`);
  };

  return (
      <div className='board-pin'>
        <div
          className='board-pin__preview'
          onClick={redirectToBoard}
        >
        </div>
        <div className='board-pin__info'>
          <div className="board-pin__info-title" title={title}>
            {title}
          </div>
        </div>
      </div>
  );
}