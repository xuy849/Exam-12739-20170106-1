package com.xuy849.pojo;

import java.util.List;

public class ResponsePage<T> {
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	private int total;
	private List<T> rows;
}
