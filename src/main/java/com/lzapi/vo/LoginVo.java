package com.lzapi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String username;
    @NotNull
    private String password;
}
