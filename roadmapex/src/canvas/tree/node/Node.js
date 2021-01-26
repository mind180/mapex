import React from 'react';
import './Node.css';
import Title from  './title/Title';
import NodeContextMenu from '../context-menu/node-context-menu/NodeContextMenu';
import ConnectingPoints from './connecting-points/ConnectingPoints';

const minWidth = 14;

export default class Node extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      width: minWidth + 'px',
      isConnectionPointsShown: false
    }

    this.handleClick = this.handleClick.bind(this);
    this.handleChangeTitle = this.handleChangeTitle.bind(this);
    this.setWidth = this.setWidth.bind(this);
    this.handleMouseEnter = this.handleMouseEnter.bind(this);
    this.handleMouseLeave = this.handleMouseLeave.bind(this);
  }

  handleClick(e) {
    if (e.target.classList.contains('color-picker-item')) {
      this.setState({ isConnectionPointsShown: false });
    }
  }

  handleChangeTitle(e) {
    const inputElement = e.target;
    this.setWidth(inputElement);
  }

  handleMouseEnter(e) {
    this.toggleConnectiongPoints(true);
  }

  handleMouseLeave(e) {
    this.toggleConnectiongPoints(false);
  }

  setWidth(inputElement) {
    const text = inputElement.value;
    const fontDescription = this.getFontDescriptor(inputElement);
    const textWidth = this.getTextWidth(text, fontDescription);
    this.setState({ width: minWidth + textWidth + 'px' });
    this.props.setLastTouchedNode(inputElement.closest('.node'));
  }

  getTextWidth(text, font) {
    const canvas = document.createElement('canvas');
    const context = canvas.getContext("2d");
    context.font = font;
    const metrics = context.measureText(text);
    return metrics.width;
  }

  getFontDescriptor(element) {
    const fontWeight = getComputedStyle(element).getPropertyValue("font-weight");
    const fontSize = getComputedStyle(element).getPropertyValue("font-size");
    const fontFamily = getComputedStyle(element).getPropertyValue("font-family");
    return fontWeight + ' ' + fontSize + ' ' + fontFamily; 
  }

  toggleConnectiongPoints(isShown) {
    this.setState({ isConnectionPointsShown: isShown });
  }

  render() {
    const style = {
      left: this.props.position.x,
      top: this.props.position.y,
      backgroundColor: this.props.color,
      width: this.state.width,
      zIndex: this.props.isContextMenuOpen ? '4000' : '1000'
    }

    return (
      <div data-id={this.props.id} className='node' style={style} data-allow-context-menu 
        onDoubleClick={this.handleDoubleClick}
        draggable
        onDragStart={this.props.handleDragStart}
        onDrag={this.props.handleDrag}
        onDragEnd={this.props.handleDragEnd}
        onClick={this.handleClick}
        onMouseEnter={this.handleMouseEnter}
        onMouseLeave={this.handleMouseLeave}
      >
        <Title text={this.props.title} 
          onChangeText={this.handleChangeTitle}
          backgroundColor={this.props.color} 
          initWidth={this.setWidth}
          handleUpdateTitle={this.props.handleUpdateTitle}
        />
        <NodeContextMenu isOpen={this.props.isContextMenuOpen}
          handleDeleteNode={this.props.handleDeleteNode}
        />
        <ConnectingPoints nodeId={this.props.id} isShown={this.state.isConnectionPointsShown}/>
      </div>
    );
  }
}
