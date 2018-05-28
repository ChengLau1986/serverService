package com.lzapi.pojo;

public class Organization {
    private String organizationid;

    private Integer tid;

    private Short orgstyle;

    private String orgname;

    private String orgcode;

    private String parentid;

    private String orgtypeid;

    private String orgaddress;

    private String orgphone;

    private String orgfax;

    private String mainleader;

    private String orgmark;

    public Organization(String organizationid, Integer tid, Short orgstyle, String orgname, String orgcode, String parentid, String orgtypeid, String orgaddress, String orgphone, String orgfax, String mainleader, String orgmark) {
        this.organizationid = organizationid;
        this.tid = tid;
        this.orgstyle = orgstyle;
        this.orgname = orgname;
        this.orgcode = orgcode;
        this.parentid = parentid;
        this.orgtypeid = orgtypeid;
        this.orgaddress = orgaddress;
        this.orgphone = orgphone;
        this.orgfax = orgfax;
        this.mainleader = mainleader;
        this.orgmark = orgmark;
    }

    public Organization() {
        super();
    }

    public String getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid == null ? null : organizationid.trim();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Short getOrgstyle() {
        return orgstyle;
    }

    public void setOrgstyle(Short orgstyle) {
        this.orgstyle = orgstyle;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getOrgtypeid() {
        return orgtypeid;
    }

    public void setOrgtypeid(String orgtypeid) {
        this.orgtypeid = orgtypeid == null ? null : orgtypeid.trim();
    }

    public String getOrgaddress() {
        return orgaddress;
    }

    public void setOrgaddress(String orgaddress) {
        this.orgaddress = orgaddress == null ? null : orgaddress.trim();
    }

    public String getOrgphone() {
        return orgphone;
    }

    public void setOrgphone(String orgphone) {
        this.orgphone = orgphone == null ? null : orgphone.trim();
    }

    public String getOrgfax() {
        return orgfax;
    }

    public void setOrgfax(String orgfax) {
        this.orgfax = orgfax == null ? null : orgfax.trim();
    }

    public String getMainleader() {
        return mainleader;
    }

    public void setMainleader(String mainleader) {
        this.mainleader = mainleader == null ? null : mainleader.trim();
    }

    public String getOrgmark() {
        return orgmark;
    }

    public void setOrgmark(String orgmark) {
        this.orgmark = orgmark == null ? null : orgmark.trim();
    }
}