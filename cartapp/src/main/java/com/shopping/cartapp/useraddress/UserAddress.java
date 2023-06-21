package com.shopping.cartapp.useraddress;

import com.shopping.cartapp.config.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "tbl_user_address")
public class UserAddress extends CommonEntity {

    @NotNull(message = "Flat No. Should Not  Be Blank")
    @NotBlank(message = "Flat No. Should Not Be Blank")
    String flatNo;
    @NotNull(message = "Address Should Not Be Blank")
    @NotBlank(message = "Address Should Not Be Blank")
    String addressLine1;
    String addressLine2;
    String landMark;

    String countryId;
    String stateId;
    String cityId;
    String zipcode;
    boolean isDefaultAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;
}
