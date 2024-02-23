package ru.pakulin.Spring.Security.Login.domain.model;

import lombok.Getter;

@Getter
public class AuthUser {
    private String jwt;

  public AuthUser(String jwt) {
    this.jwt = jwt;
  }

}
