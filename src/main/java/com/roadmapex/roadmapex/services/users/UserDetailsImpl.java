package com.roadmapex.roadmapex.services.users;

import com.roadmapex.roadmapex.model.Role;
import com.roadmapex.roadmapex.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
  private User user;

  public UserDetailsImpl(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<Role> lstRoles = user.getRoles();
    List<SimpleGrantedAuthority> lstAuthority = new ArrayList<>();

    for (Role role : lstRoles) {
      SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
      lstAuthority.add(authority);
    }

    return lstAuthority;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isEnabled() {
    return user.isEnabled();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }
}
