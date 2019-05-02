package org.total.entity;

import java.util.List;

/**
 * 分页实现
 * @param <T>
 */
public class PageInfo<T> {
	private int page;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private int start;
	private int end;
	public static int size=5;


	private List<T> list;//每页显示数据

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	public PageInfo(int page, int pageSize, int totalCount) {
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);//计算总页数
		this.page = page;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = num.intValue();
		this.start = (page - 1)*pageSize;
		this.end = pageSize;
	}

	public PageInfo() {
	}
}
