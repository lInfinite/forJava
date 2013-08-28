package com.util;

import java.util.List;

public class Page {

	
	private int page=0;
	private int next=0;
	private int back=0;
	private int end=0;
	private int max_results=0;
    private int list_size=0;
    
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


	
	
	
	public int getEnd() {
		return end;
	}

	public void setList_size_and_End(List size){
		this.list_size = size.size();
		if(list_size % this.max_results == 0){
		    this.end = list_size / this.max_results -1;
		}else if(list_size% this.max_results  > 0){
			this.end = list_size / this.max_results ;
		}
	}
	
/*	public void setEnd(int end, int page) {
		this.end = end%page;
	}
*/
	
	
    public int getMax_results() {
		return max_results;
	}

	public void setMax_results(int max_results) {
		this.max_results = max_results;
	}

	public int getList_size() {
		return list_size;
	}
 
/*	public void setList_size(List list) {
		this.list_size = list.size();
	}
*/

}
