package com.lzapi.dao;

import com.lzapi.pojo.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(String organizationid);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String organizationid);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}