package de.cdelmonte.authentication.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_roles")
public class Role implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "user_role_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String userRoleId;

  @Column(name = "role", nullable = false)
  private String role;

  @Column(name = "user_name", nullable = true)
  private String userName;

  public String getUserRoleId() {
    return userRoleId;
  }

  public void setUserRoleId(String userRoleId) {
    this.userRoleId = userRoleId;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
