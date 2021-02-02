import React, {useState} from 'react';
import './BoardPin.css'
import { useHistory } from 'react-router-dom';
import BoardPinMenu from "../board-pin-menu/BoardPinMenu";

export default function BoardPin(props) {
  const {id: canvasId, title, description} = props;
  const history = useHistory();
  const [open, setOpen] = useState(false);

  const toggleMenu = (e) => {
    setOpen(!open);
    e.stopPropagation();
  };

  const closeMenu = () => setOpen(false);

  const redirectToBoard = () => {
    history.push(`/canvas/${canvasId}`);
  };

  return (
      <div className='board-pin'
        onClick={redirectToBoard}
      >
        <div className='board-pin__preview'
          onMouseLeave={closeMenu}
        >
          <div className="board-pin__description">
            <div className="board-pin__menu-btn"
              onClick={toggleMenu}
            >
              ...
              <BoardPinMenu
                isOpen={open}
                canvasId={canvasId}
              />
            </div>
            {description}
          </div>
        </div>
        <div className='board-pin__info'>
          <div className="board-pin__info-title" title={title}>
            {title}
          </div>
        </div>
      </div>
  );
}