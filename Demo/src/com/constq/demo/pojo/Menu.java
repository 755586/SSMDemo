package com.constq.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Menu implements Serializable {//实体对象都实现“Serializable”接口，方便序列化
    private static final long serialVersionUID = 3043503354681494347L;
    protected String id;//主键

    private String name;//名称

    private String url;//菜单地址

    private String pId;//上级ID

    private Short sort;//排序

    private Short status;//状态

    private User modUser;//修改用户
    
    private Date modTime;//修改时间

    private String icon;//显示图标

    

	public Menu() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public Short getSort() {
		return sort;
	}

	public void setSort(Short sort) {
		this.sort = sort;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public User getModUser() {
		return modUser;
	}

	public void setModUser(User modUser) {
		this.modUser = modUser;
	}

	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", url=" + url + ", pId="
				+ pId + ", sort=" + sort + ", status=" + status + ", modUser="
				+ modUser + ", modTime=" + modTime + ", icon=" + icon + "]";
	}
    
}