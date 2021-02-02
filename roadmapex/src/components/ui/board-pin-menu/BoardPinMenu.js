import React from "react";
import './BoardPinMenu.css';

export default function BoardPinMenu(props) {
  const { isOpen, canvasId } = props;

  const handleCanvasDelete = () => {
    console.log(canvasId);
  };

  return (
    <ul
      className="board-pin__menu"
      style={{display: isOpen  ? "block" : "none"}}
    >
      <li className="board-pin__menu-item"
        onClick={handleCanvasDelete}
      >
        Delete
      </li>
      <li className="board-pin__menu-item">Edit</li>
    </ul>
  )
}