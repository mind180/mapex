import React from 'react';
import './ModalContent.css';

export default function ModalContent({ children }) {
  return (
      <div className='modal-content'>
        {children}
      </div>
  );
}