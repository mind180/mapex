import React from 'react';
import './ProfileHeader.css'

export default function ProfileHeader() {
  return (
    <div className='profile-header'>
      <div className="profile-header__background-image">
        <div className="profile-header__content">
          <div className="profile-header__avatar mock-avatar"></div>
          <div className="profile-header__info">
            <div className="profile-header__info-content">
              <h2 className="profile-header__info-item">Username</h2>
              <h3 className="profile-header__info-item">First Last</h3>
              <h3 className="profile-header__info-item">Toronto, Canada</h3>
            </div>
            <div className="profile-header__edit-background">
              <input type="button" value={'edit background'}/>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}