import React from "react";
import './BoardPinMenu.css';
import {processEntity} from "../../../api/api";

export default function BoardPinMenu(props) {
  const { isOpen, canvasId, hideBoardPin } = props;

  const handleCanvasDelete = () => {
    processEntity('DELETE', `/canvas/${canvasId}`)
      .then(responseOk => hideBoardPin())
      .catch(error => console.log(error));
  };

  return (
    <ul className="board-pin__menu"
        style={{display: isOpen  ? "block" : "none"}}
    >
      <li className="board-pin__menu-item"
          onClick={handleCanvasDelete}
      >
        Delete
      </li>
      <li className="board-pin__menu-item">
        Edit
      </li>
    </ul>
  )
}