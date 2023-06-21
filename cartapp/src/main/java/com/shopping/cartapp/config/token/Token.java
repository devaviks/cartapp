package com.shopping.cartapp.config.token;

import com.shopping.cartapp.config.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.CommonEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token extends CommonEntity {

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  public boolean revoked;

  public boolean expired;

  @Column(unique = true)
  public String deviceToken;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  public User user;
}
