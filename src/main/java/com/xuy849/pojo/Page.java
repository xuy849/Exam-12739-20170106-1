package com.xuy849.pojo;

public class Page<T> {
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}

	private int page;	//当前页码
	private int maxSize;	//页面最大容积
	private T entity;	//封装了查询信息的实体类
	private int offset;	//偏移
	public int getOffset() {
		return (page-1)*maxSize;
	}
}
