import React from 'react';
import './ColorPicker.css';
import { nodeColors } from '../../../../config.js';

export default class ColorPicker extends React.Component {
  render() {
    if (!this.props.isShown) return null;

    return (
      <div className='color-picker'>
        {nodeColors.map((color, index) => (
          <div key={index} className='color-picker-item' style={{backgroundColor: color}} 
            title={color} data-color={color}></div>
        ))}
      </div>    
    )
  }
}
