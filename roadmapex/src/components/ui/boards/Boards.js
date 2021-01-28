import React, { useState } from 'react';
import BoardPin from '../board-pin/BoardPin';
import './Boards.css';

export default function Boards() {
  return(
    <div className="boards-holder">
      {[1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15].map(num =>
        <BoardPin />
      )}
    </div>
  );
}