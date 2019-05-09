package com.tdd.tddMockito.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tdd.tddMockito.domain.BookDTO;

public class BookDAO {
	public BookDTO searchBookById(Integer idBook, Connection connection) 
													throws SQLException {
		StringBuilder selectSQL;
		BookDTO foundBook;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		try {
			selectSQL = new StringBuilder();
			foundBook = null;
			
			selectSQL.append("SELECT ");
			
			selectSQL.append("book.id,");
			selectSQL.append("book.title,");
			selectSQL.append("book.author,");
			selectSQL.append("book.editorial,");
			selectSQL.append("book.pages,");
			selectSQL.append("book.age");
			
			selectSQL.append(" FROM ");
			
			selectSQL.append("book");
			
			selectSQL.append(" WHERE ");
			selectSQL.append("id = ?");
			
			preparedStatement = connection.prepareStatement(selectSQL.toString());
			
			preparedStatement.setInt(1, idBook);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				foundBook = new BookDTO();
				
				foundBook.setId(resultSet.getInt("id"));
			}
			
			return foundBook;
		} catch(SQLException exception) {
			throw exception;
		}
	}
}
