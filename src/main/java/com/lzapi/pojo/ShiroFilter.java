package com.lzapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by lc on 2018/7/2.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShiroFilter {
    private Integer id;
    private String name;
    private String perms;

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    private Integer sortOrder;
}
