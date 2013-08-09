package com.util;

public class Page {

	
	private int page;
	private int next;
	private int back;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	
	public int getNext() {
		return this.page+1;
	}

	public void setNext(int next) {
		this.next = next;
	}

	
	public int getBack() {
		return this.page-1;
	}

	public void setBack(int back) {
		this.back = back;
	}
    
    
}
