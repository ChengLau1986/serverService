package com.lzapi.pojo;

public class User {
    private String userid;

    private Integer tid;

    private String account;

    private String username;

    private String userpwd;

    private String organizationid;

    private String lawnumber;

    private String idnumber;

    private String logindeviceid;

    private String postid;

    private String userphoto;

    private String departmentid;

    private Integer deletemark;

    public User(String userid, Integer tid, String account, String username, String userpwd, String organizationid, String lawnumber, String idnumber, String logindeviceid, String postid, String userphoto, String departmentid, Integer deletemark) {
        this.userid = userid;
        this.tid = tid;
        this.account = account;
        this.username = username;
        this.userpwd = userpwd;
        this.organizationid = organizationid;
        this.lawnumber = lawnumber;
        this.idnumber = idnumber;
        this.logindeviceid = logindeviceid;
        this.postid = postid;
        this.userphoto = userphoto;
        this.departmentid = departmentid;
        this.deletemark = deletemark;
    }

    public User() {
        super();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid == null ? null : organizationid.trim();
    }

    public String getLawnumber() {
        return lawnumber;
    }

    public void setLawnumber(String lawnumber) {
        this.lawnumber = lawnumber == null ? null : lawnumber.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getLogindeviceid() {
        return logindeviceid;
    }

    public void setLogindeviceid(String logindeviceid) {
        this.logindeviceid = logindeviceid == null ? null : logindeviceid.trim();
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid == null ? null : postid.trim();
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto == null ? null : userphoto.trim();
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid == null ? null : departmentid.trim();
    }

    public Integer getDeletemark() {
        return deletemark;
    }

    public void setDeletemark(Integer deletemark) {
        this.deletemark = deletemark;
    }
}