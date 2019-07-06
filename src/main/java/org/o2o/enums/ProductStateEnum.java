package org.o2o.enums;

public enum ProductStateEnum {
	CHECK(0,"审核中"),
	OFFLINE(-1,"非法商品"),
	SUCCESS(1,"操作成功"),
	EMPTY(-2,"无商品"),
	INNER_ERROR(-1001,"内部系统错误");
	private int state;
	private String stateInfo;
	private ProductStateEnum(int state,String sateInfo) {
		this.state=state;
		this.stateInfo=sateInfo;
	}
	/**
	 * 依据传入的state返回相应的enum值
	 */
	public static ProductStateEnum stateOf(int state) {
		for(ProductStateEnum stateEnum:values()) {
			if(stateEnum.getState()==state) {
				return stateEnum;
			}
		}
		return null;
	}
	public int getState() {
		return state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
}
