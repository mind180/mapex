import React from 'react';

export default class Edge extends React.Component {
  render() {
    if (!this.props.isShown) return null;

    const directionName = this.getDirectionName(this.props.from, this.props.to);
    const positionStyle = this.positionStyle[directionName](this.props.from, this.props.to);
    const d = this.drawCommand[directionName](positionStyle.height, positionStyle.width);

    const style = {
      position: 'absolute',
      top: positionStyle.y,
      left: positionStyle.x,
      height: positionStyle.height,
      width: positionStyle.width
    };
    
    return (
      <svg xmlns="http://www.w3.org/2000/svg" style={style}>
        <path d={d} stroke="black" fill="transparent"></path>
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

  drawCommand = {
    BottomRight: function(height, width) {
      return "M0 0 " + 
      "Q " + width / 3.5 + " 0 " +
      width / 2 + " " + height / 2 +
      " T " + width + " " + height;
    },
    BottomLeft: function(height, width) {
      return "M" + width + " 0 " + 
      "Q " + width / 1.5 + " 0 " +
      width / 2 + " " + height / 2 +
      " T 0 " + height;
    },
    TopLeft: function(height, width) {
      return "M0 0 " + 
      "Q " + width / 3.5 + " 0 " +
      width / 2 + " " + height / 2 +
      " T " + width + " " + height;
    },
    TopRight: function(height, width) {
      return "M0 " + height + " " + 
      "Q " + width / 3.5 + " " + height + " " +
      width / 2 + " " + height / 2 +
      " T " + width + " " + 0;
    }
  };

  positionStyle = {
    BottomRight: function(from, to) {
      return {
        x: from.x, 
        y: from.y,
        width: Math.floor(to.x - from.x) ? to.x - from.x : 1,
        height: Math.floor(to.y - from.y) ? to.y - from.y : 1
      };
    },
    BottomLeft: function(from, to) {
      return {
        x: to.x,
        y: from.y,
        width: Math.floor(from.x - to.x) ? from.x - to.x : 1,
        height: Math.floor(to.y - from.y) ? to.y - from.y : 1
      };
    },
    TopRight: function(from, to) {
      return {
        x: from.x, 
        y: to.y,
        width: Math.floor(to.x - from.x) ? to.x - from.x : 1,
        height: Math.floor(from.y - to.y) ? from.y - to.y : 1
      };
    },
    TopLeft: function(from, to) {
      return {
        x: to.x,
        y: to.y,
        width: Math.floor(from.x - to.x) ? from.x - to.x : 1,
        height: Math.floor(from.y - to.y) ? from.y - to.y : 1
      };
    }
  };
}
