package com.lzapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by lc on 2018/5/31.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer roleId;
    private String roleName;
    private String deleteStatus;
    private List<Permission> permissions;
}
