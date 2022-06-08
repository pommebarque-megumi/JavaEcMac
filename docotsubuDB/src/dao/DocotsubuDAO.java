package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.User;

public class DocotsubuDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	public void connect() throws NamingException, SQLException {
		Context context=new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/jsp");
		this.db=ds.getConnection();
	}
	private void disconnect() {
		try {
			if(rs!=null) {rs.close();}
			if(ps!=null) {ps.close();}
			if(db!=null) {db.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<User>findAll(){
		List<User> userList = new ArrayList<>();
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM users ORDER BY ASK");
			rs=ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String comment = rs.getString("mutter");
				User user = new User(id,name,comment);
				userList.add(user);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return userList;
	}

	public void insertOne(User user) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO users(name,mutter) VALUES(?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getComment());
			ps.execute();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
	}
}
