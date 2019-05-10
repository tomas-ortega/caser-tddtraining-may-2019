package com.tdd.tddMockito;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.tdd.tddMockito.bs.BookBS;
import com.tdd.tddMockito.bs.DBConnection;
import com.tdd.tddMockito.dao.BookDAO;
import com.tdd.tddMockito.domain.BookDTO;

@ExtendWith(MockitoExtension.class)
public class BookBSTest {
	
	@InjectMocks
	private BookBS bookBS;
	
	@Mock
	private BookDAO bookDAO;
	
	@Mock
	private DBConnection dbConnection;
	
	@Spy
	private static List<String> spyDataList;
	
	private static BookDAOTestHelper BSHelper;
	
	@BeforeAll
	public static void setUpClass() {
		BSHelper = new BookDAOTestHelper();
		spyDataList = new ArrayList<String>();
	}
	
	@BeforeEach
	public void setUpMocks() throws Exception {
		this.initializeMockSearchBookWithId2And390Pages();
		//this.bookBS.setBookDAO(bookDAOInyection);
		
		//this.initializeMockDbConnection();
	}
	
	@Test
	@Disabled
	public void testSpy() {
		//List<String> spyDataList = Mockito.spy(new ArrayList<String>());
		
		spyDataList.add("A");
		spyDataList.add("B");
		
		assertTrue(spyDataList.size() == 2);
		
		Mockito.doReturn(4)
				.when(spyDataList)
				.size();
		
		assertEquals(4, spyDataList.size());
	}
	
	@Test
	public void searchBookWithId2And390Pages() throws Exception {
		Integer bookIdToSearch = BSHelper.getBookWithId2And390Pages().getId();
		BookDTO foundBook;
		
		foundBook = this.bookBS.searchBookById(bookIdToSearch);
		
		assertTrue(foundBook.getId().equals(bookIdToSearch));
	}
	
	private void initializeMockSearchBookWithId2And390Pages() 
													throws Exception {
		when(this.bookDAO.searchBookById(BSHelper.getBookWithId2And390Pages()
																	.getId(), 
																null))
			.thenReturn(BSHelper.getBookWithId2And390Pages());
	}
	
	private void initializeMockDbConnection() 
											throws Exception {
		when(this.dbConnection.getDbConnection())
			.thenReturn(null);
	}
}
