package yomg_joom01;

import java.util.Enumeration;

public class Book implements Enumeration{
	
		private String title;
		private int proce;	
		
	public Book() {
			super();
		}

	public Book(String title, int proce) {
			super();
			this.title = title;
			this.proce = proce;
		}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getProce() {
		return proce;
	}

	public void setProce(int proce) {
		this.proce = proce;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", proce=" + proce + "]";
	}

	
}
