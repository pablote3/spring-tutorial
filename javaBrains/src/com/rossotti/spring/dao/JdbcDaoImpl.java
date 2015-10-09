package com.rossotti.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rossotti.spring.model.Circle;

@Component
public class JdbcDaoImpl {
	@Autowired
	private DataSource dataSource;
	
	public Circle getCircle(int circleId) {
		Connection connection = null;
				
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from circle where id = ?");
			ps.setInt(1, circleId);
			
			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
				
			}
			rs.close();
			ps.close();
			return circle;
		} 
		catch (SQLException e) {
			throw new RuntimeException();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
