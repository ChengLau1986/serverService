package com.lzapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by lc on 2018/5/31.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private Integer permissionId;
    private String menuCode;
    private String menuName;
    private String permissionCode;
    private String permissionName;
    private String requiredPermission;
    private String url;
}
