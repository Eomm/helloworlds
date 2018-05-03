import React from 'react';
import ReactDOM from 'react-dom';
import ReactCursorPosition from 'react-cursor-position';
import './finger-follow.css';

class Hand extends React.Component {
  constructor(props) {
    super(props);
    this.state = { char: props.initChar };
  }

  contains(x, y) {
    /* {
    "x":127.4375,
    "y":75.4000015258789,
    "width":695.6749877929688,
    "height":22,
    "top":75.4000015258789,
    "right":823.1124877929688,
    "bottom":97.4000015258789,
    "left":127.4375} 
    */
    const box = this.ref.getBoundingClientRect();
    //  console.log(x + '-' + y + ' //// ' + box.x + '-' + box.y);


    let out = -1;


    if (x >= box.x && x <= box.x + box.width && y >= box.y && y <= box.y + box.height) {
      out = 5;
    } else if (x < box.x && y < box.y) {
      out = 1;
    } else if (x < box.x && y < box.y + box.height) {
      out = 4;
    } else if (x < box.x && y > box.y + box.height) {
      out = 7;
    } else if (x > box.x + box.width && y < box.y) {
      out = 3;
    } else if (x > box.x + box.width && y < box.y + box.height) {
      out = 6;
    } else if (x > box.x + box.width && y > box.y + box.height) {
      out = 9;
    } else if (x > box.x && x < box.x + box.width && y < box.y) {
      out = 2;
    } else if (x > box.x && x < box.x + box.width && y > box.y + box.height) {
    }
    return out;
  }

  updateState(mouseEvent) {
    let char;
    const isIn = this.contains(mouseEvent.clientX, mouseEvent.clientY);

    switch (isIn) {
      case 1:
        char = '✊🏿';
        break;
      case 9:
        char = '✊';
        break;
      case 7:
        char = '✊🏾';
        break;
      case 3:
        char = '✊🏼';
        break;
      case 2:
        char = '👆🏼'
        break;
      case 4:
        char = '👈🏼'
        break;
      case 5:
        char = '🖐🏼';
        break;
      case 6:
        char = '👉🏼';
        break;
      default: ;
        char = '👇🏼';
        // char = this.props.initChar;
        break;
    }

    this.updateChar(char);
  }

  updateChar(char) {
    this.setState({ char: char })
  }

  render() {
    return (
      <button className="hand"
        ref={e => this.ref = e}
      // onMouseMove={this.props.onMouseMove}
      // onMouseOver={this.updateChar.bind(this, '👊🏽')}
      // onMouseLeave={this.updateChar.bind(this, '✋🏼')}
      >
        {this.state.char}
      </button>
    );
  }
}

function Br() {
  return <br></br>;
}

class Board extends React.Component {
  constructor(props) {
    super(props);

    const squares = 100;
    this.rows = [];//Array(squares);
    const view = [];

    this.state = {
      squares,
      view
    };

    let i = 0;
    do {
      if (i % 10 === 0) {
        view.push(<Br />);
      }
      view.push(<Hand initChar='✋🏼' ref={(e) => { this.rows.push(e); }} />);
    } while (++i < squares);

  }

  updateState(mouseEvent) {
    this.rows.forEach(r => r.updateState(mouseEvent));
  }

  render() {
    console.log('render');
    return (
      <div>
        <div className="grill-row" onMouseMove={this.updateState.bind(this)}>
          {this.state.view}
        </div>
      </div>
    );
  }
}

class Grill extends React.Component {
  render() {
    return (
      <div className="grill">
        <div className="grill-board">
          <Board />
        </div>
      </div>
    );
  }
}
// ========================================

export default Grill;