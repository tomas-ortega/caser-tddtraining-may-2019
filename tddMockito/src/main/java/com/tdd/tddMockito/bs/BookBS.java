package com.tdd.tddMockito.bs;

import java.sql.Connection;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.tdd.tddMockito.dao.BookDAO;
import com.tdd.tddMockito.domain.BookDTO;

@Stateless(name="BookBS")
public class BookBS {
	
	private BookDAO bookDAO;
	
	private DBConnection dbConnection;
	
	public BookDTO searchBookById(Integer bookIdToSearch) 
												throws Exception {
		Connection connection = null;
		
		try {
			connection = this.dbConnection.getDbConnection();
			
			return this.bookDAO.searchBookById(bookIdToSearch, 
											   connection);
		} catch(Exception exception) {
			throw exception;
		} finally {
			this.dbConnection.closeConnection(connection);
		}
	}
	
	@Inject
	public void setBookDAO(BookDAO bookDAOInyection) {
		this.bookDAO = bookDAOInyection;
	}
	
	@Inject
	public void setConnectionDB(DBConnection connectionDbInyection) {
		this.dbConnection = connectionDbInyection;
	}
}
