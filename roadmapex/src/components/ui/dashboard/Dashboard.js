import React, { useState } from 'react';
import AddBoard from "../add-board/AddBoard";
import BoardPin from '../board-pin/BoardPin';
import './Dashboard.css';

export default function Dashboard() {
  return(
    <div className="boards-holder">
      <AddBoard/>
      {[1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15].map(num =>
        <BoardPin/>
      )}
    </div>
  );
}