import React, {useRef} from 'react';
import './EditCanvas.css';
import Modal from '../Modal';

export default function EditCanvas({ onCancel, onCreate}) {
  const titleElement = useRef();
  const descriptionElement = useRef();

  const handleClickCreate = () => {
    const name = titleElement.current.value;
    const description = descriptionElement.current.value;

    onCreate({ name, description});
  };

  return (
      <Modal.Content>
        <Modal.Body>
          <div className="modal-body-item">
            <input ref={titleElement} placeholder='Title' type="text"/>
          </div>
          <div className="modal-body-item">
            <textarea ref={descriptionElement} placeholder='Description'/>
          </div>
        </Modal.Body>
        <Modal.Footer>
          <Modal.PrimaryButton action={onCancel}>
              Cancel
          </Modal.PrimaryButton>
          <Modal.PrimaryButton action={handleClickCreate}>
            Create
          </Modal.PrimaryButton>
        </Modal.Footer>
      </Modal.Content>
  );
}