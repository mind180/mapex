import React from 'react';
import './Title.css';

export default class Title extends React.Component {
  constructor(props) {
    super(props);
    this.inputElement = React.createRef();
  }

  componentDidMount() {
    this.props.initWidth(this.inputElement.current);
  }

  render() {
    const style = {
      backgroundColor: this.props.backgroundColor
    }

    return (
      <input ref={this.inputElement}
        className='node-title' 
        defaultValue={this.props.text}
        style={style} 
        draggable onDragStart={e => e.preventDefault()}
        onChange={this.props.onChangeText}
        onBlur={this.props.handleUpdateTitle}
      />
    )
  }
}
