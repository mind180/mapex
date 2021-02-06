import React, {useState} from "react";
import './BoardPinMenu.css';
import {processEntity} from "../../../api/api";
import Modal from "../modal/Modal";

export default function BoardPinMenu(props) {
  const { isOpen, canvasId, canvasTitle, canvasDescription, hideBoardPin } = props;
  const [isModalOpen, setIsModalOpen] = useState(false);

  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

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
          onClick={openModal}
      >
        Edit
      </li>
      <li className="board-pin__menu-item"
          onClick={handleCanvasDelete}
      >
        Delete
      </li>
      {
        isModalOpen ? (
            <Modal>
              <Modal.EditCanvas
                title={canvasTitle}
                description={canvasDescription}
                onCancel={closeModal}
              />
            </Modal>
        ) : null
      }
    </ul>
  )
}