package com.tdd.tddMockito;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tdd.tddMockito.dao.BookDAO;
import com.tdd.tddMockito.domain.BookDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class BookDAOTest {
	
	@Mock
	private Connection connection;
	
	@Mock
	private PreparedStatement preparedStatement;
	
	@Mock
	private ResultSet resultSet;
	
	@InjectMocks
	private BookDAO bookDAO;
	
	private static BookDAOTestHelper DAOHelper;
	
	@BeforeAll
	static void setUpClass() {
		DAOHelper = new BookDAOTestHelper();
	}
	
	@BeforeEach
	void setUpMocks() throws Exception {
		this.initializeMockSearchBookWithId2And390Pages();
	}
	
	@Test
	@Disabled
	void searchBookWithId2And390Pages() throws SQLException {
	   Integer idBook = 
			   DAOHelper.getBookWithId2And390Pages().getId();
       Integer expectedValue = 
    		   DAOHelper.getBookWithId2And390Pages().getId();
       
       BookDTO foundBook = this.bookDAO.searchBookById(idBook, this.connection);
       
       assertNotNull(foundBook);
       assertEquals(foundBook.getId(), expectedValue);
	}
	
	private void initializeMockSearchBookWithId2And390Pages() throws Exception {
		StringBuilder selectSQL = new StringBuilder();
		
		selectSQL.append("SELECT ");
		
		selectSQL.append("book.id,");
		selectSQL.append("book.title,");
		selectSQL.append("book.author,");
		selectSQL.append("book.editorial,");
		selectSQL.append("book.pages");
		
		selectSQL.append(" FROM ");
		
		selectSQL.append("book");
		
		selectSQL.append(" WHERE ");
		selectSQL.append("id = ?");
		
		/* Mocking preparedStatement*/
		when(this.connection.prepareStatement(selectSQL.toString()))
			.thenReturn(this.preparedStatement);
		
		/* Mocking the executionQuery*/
		when(this.preparedStatement.executeQuery())
			.thenReturn(this.resultSet);
				
		/* Mocking the resultSet iterator */
		when(this.resultSet.next())
			.thenReturn(true)
				.thenReturn(false);
		
		/* Mocking the resultSet parameters */
		when(this.resultSet.getInt("id"))
			.thenReturn(DAOHelper.getBookWithId2And390Pages().getId());
		
		/*when(this.resultSet.getString("title"))
		.thenReturn(DAOHelper.getBookWithId2And390Pages().getTitle());
		
		when(this.resultSet.getString("author"))
		.thenReturn(DAOHelper.getBookWithId2And390Pages().getAuthor());
		
		when(this.resultSet.getString("editorial"))
		.thenReturn(DAOHelper.getBookWithId2And390Pages().getEditorial());
		
		when(this.resultSet.getInt("pages"))
		.thenReturn(DAOHelper.getBookWithId2And390Pages().getPages());*/
	}
}
