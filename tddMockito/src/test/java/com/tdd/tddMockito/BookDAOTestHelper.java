package com.tdd.tddMockito;

import com.tdd.tddMockito.domain.BookDTO;

public class BookDAOTestHelper {
	private BookDTO bookFoundWithId2And390Pages;
	
	public BookDAOTestHelper() {
		this.bookFoundWithId2And390Pages = null;
		this.initBookWithId2And390Pages();
	}
	
	private void initBookWithId2And390Pages() {
		this.bookFoundWithId2And390Pages = new BookDTO();
		
		this.bookFoundWithId2And390Pages.setId(2);
		this.bookFoundWithId2And390Pages.setTitle("Los pilares de la tierra");
		this.bookFoundWithId2And390Pages.setAuthor("Ken Follet");
		this.bookFoundWithId2And390Pages.setPages(390);
	}
	
	public BookDTO getBookWithId2And390Pages() {
		return this.bookFoundWithId2And390Pages;
	}
}
