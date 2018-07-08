package com.lzapi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by lc on 2018/6/7.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {

    @NotNull
//    @NotEmpty
    @NotBlank
    private String username;
    @NotNull
//    @NotEmpty
    @NotBlank
    private String password;
}
