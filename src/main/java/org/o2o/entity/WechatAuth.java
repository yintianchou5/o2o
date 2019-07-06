package org.o2o.entity;

import java.util.Date;
//微信账号
public class WechatAuth {
	private Long wechartAuthId;
	private String openId;
	private Date createTime;
	private PersonInfo personInfo;
	public Long getWechartAuthId() {
		return wechartAuthId;
	}
	public void setWechartAuthId(Long wechartAuthId) {
		this.wechartAuthId = wechartAuthId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	
}
