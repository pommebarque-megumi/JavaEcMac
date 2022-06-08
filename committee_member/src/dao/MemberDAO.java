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

import model.Member;

public class MemberDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException, SQLException {
		Context context = new InitialContext();
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
	public List<Member>findAll(){
		List<Member> membersList = new ArrayList<>();
try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM members");
			rs=ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String position = rs.getString("position");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phoneNo = rs.getString("phoneNo");
				String affiliation = rs.getString("affiliation");
				String reading = rs.getString("reading");
				Member member = new Member(id,position,name,address,phoneNo,affiliation,reading);
				membersList.add(member);
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return membersList;
	}
	public void insertOne(Member member) {
		try {
			this.connect();
			ps=db.prepareStatement("INSERT INTO members(position,name,address,phoneNo,affiliation,reading) VALUES(?,?,?,?,?,?)");
			ps.setString(1, member.getPosition());
			ps.setString(2, member.getName());
			ps.setString(3, member.getAddress());
			ps.setString(4, member.getPhoneNo());
			ps.setString(5, member.getAffiliation());
			ps.setString(6, member.getReading());
			ps.execute();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
		public void updateOne(Member member) {
			try {
				this.connect();
				ps=db.prepareStatement("UPDATE members SET position=?,name=?,address=?,phoneNo=?,affiliation=?,reading=? WHERE id=?");
				ps.setString(1, member.getPosition());
				ps.setString(2, member.getName());
				ps.setString(3, member.getAddress());
				ps.setString(4, member.getPhoneNo());
				ps.setString(5, member.getAffiliation());
				ps.setString(6, member.getReading());
				ps.setInt(7, member.getId());
				ps.executeUpdate();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
		}
		public Member findOne(int id) {
			Member member = null;
			try {
				this.connect();
				ps=db.prepareStatement("SELECT * FROM members WHERE id=?");
				ps.setInt(1, id);
				rs=ps.executeQuery();
				if(rs.next()) {
					String position = rs.getString("position");
					String name = rs.getString("name");
					String address = rs.getString("address");
					String phoneNo = rs.getString("phoneNo");
					String affiliation = rs.getString("affiliation");
					String reading = rs.getString("reading");
					member = new Member(id,position,name,address,phoneNo,affiliation,reading);
				}
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
			return member;
		}
		public void deleteOne(int id) {
			try {
				this.connect();
				ps=db.prepareStatement("DELETE FROM members WHERE id=?");
				ps.setInt(1,id);
				ps.execute();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}finally {
				this.disconnect();
			}
		}
}
