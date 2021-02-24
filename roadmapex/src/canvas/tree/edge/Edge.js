import React from 'react';
import { pathForm } from './lib/pathForm';
import { position } from './lib/position';

export default class Edge extends React.Component {
  render() {
    if (!this.props.isShown) return null;

    const {from, to, width = 1, type = 'straight'} = this.props;

    const directionName = this.getDirectionName(from, to);

    const positionStyle = position[directionName](from, to, width);
    const style = {
      position: 'absolute',
      top: positionStyle.y,
      left: positionStyle.x,
      height: positionStyle.height,
      width: positionStyle.width
    };

    const d = pathForm[type][directionName](positionStyle.height, positionStyle.width, width);

    return (
      <svg xmlns="http://www.w3.org/2000/svg" style={style}>
        <path d={d} stroke="black" strokeLinecap="round" fill="transparent" strokeWidth={width}/>
      </svg>
    );
  }

  getDirectionName(from ,to) {
    return this.getVerticalName(from, to) + this.getHorizontalName(from, to);
  }

  getHorizontalName(from, to) {
    if (this.isRight(from, to)) {
      return 'Right';
    }
    return 'Left';
  }

  getVerticalName(from, to) {
    if (this.isTop(from, to)) {
      return 'Top';
    }
    return 'Bottom';
  }

  isRight(from, to) {
    return from.x < to.x;
  }

  isTop(from, to) {
    return from.y > to.y;
  }
}
