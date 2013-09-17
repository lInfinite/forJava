package util;

public class Page {
	
    private int page;
    private int next;
    private int back;
    private int end;
    private int max;
    private boolean has_next;
    private boolean has_back;
    
    
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	
	public int getNext() {
		return page+1;
	}
	
	public void setNext(int next) {
		this.next = next;
	}
	
	
	public int getBack() {
		return page-1;
	}
	
	public void setBack(int back) {
		this.back = back;
	}
	
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public boolean isHas_next() {
		return this.next<=end;
	}
	
	public void setHas_next(boolean has_next) {
		this.has_next = has_next;
	}
	
	
	public boolean isHas_back() {
		return this.back>=0;
	}
	
	public void setHas_back(boolean has_back) {
		this.has_back = has_back;
	}
    
    
}
