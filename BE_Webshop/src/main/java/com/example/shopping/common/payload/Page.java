package com.example.shopping.common.payload;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int pageSize = 0;
	private int pageNumber = 0;
	private int totalPages = 0;
	private int totalItems = 0;
	private List<T> result;

	public Page() {

	}

	public static <T> Page<T> of(int pageSize, int pageNumber, int  totalPages, int totalItems, List<T> result) {
		Page<T> page = new Page<>();
		page.setPageSize(pageSize);
		page.setPageNumber(pageNumber);
		page.setTotalPages(totalPages);
		page.setTotalItems(totalItems);
		page.setResult(result);
		return page;
	}
	
	public static int calTotalPages(int totalItems, int pageSize) {
		return pageSize <= 0 ? 0 : (totalItems % pageSize == 0 ? (totalItems / pageSize) : (totalItems / pageSize + 1));
	}
	
	@SuppressWarnings("rawtypes")
	public static Page empty() {
		return of(0, 0, 0, 0, null);
	}

	@SuppressWarnings("rawtypes")
	public Result toResult(Integer code, String message) {
		return Result.result(code, message, this);
	}
	
	@SuppressWarnings("rawtypes")
	public Result toResult() {
		return Result.success(this);
	}
	
	public Page<T> calTotalPages(){
		totalPages = calTotalPages(totalItems, pageSize);
		return this;
	}
}
