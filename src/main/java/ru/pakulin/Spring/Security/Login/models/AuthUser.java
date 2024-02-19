package ru.pakulin.Spring.Security.Login.models;

import lombok.Getter;

@Getter
public class AuthUser {
    private String jwt;

  public AuthUser(String jwt) {
    this.jwt = jwt;
  }

}
