import React from 'react';
import './Header.css';
import logo from './Logo2.png';

export default function Header() {
  return (
    <header className='header'>
      <div className='header__left'>
        <div className='header__logo'><img src={logo} height='60px' alt='Logo'/></div>
        <div className='header__item br-1'>Home</div>
        <div className='header__item br-1'>Library</div>
      </div>
      <div className='header__right'>
        <div className='header__user-nav'>
          <div className='header__user-name'>Username</div>
          <div className='header__user-avatar'></div>
        </div>
      </div>
    </header>
  );
}
