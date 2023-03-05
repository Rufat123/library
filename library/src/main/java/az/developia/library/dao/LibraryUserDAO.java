package az.developia.library.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import az.developia.library.model.LibraryUser;

@Component
public class LibraryUserDAO  {
	@Autowired
	private DataSource dataSource;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public boolean createUser(LibraryUser libraryUser) {
		boolean userExists=false;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select username from users where username=?");
			ps.setString(1, libraryUser.getUsername());
			ResultSet rs=ps.executeQuery();
			
			if (rs.next()) {
				userExists=true;
				ps.close();
			}else {
				rs.close();
				ps.close();
				ps=conn.prepareStatement("insert into users (username,password,enabled) values(?,?,?);");
				ps.setString(1, libraryUser.getUsername());
				ps.setString(2, "{bcrypt}"+ passwordEncoder.encode(libraryUser.getPassword()));
				ps.setByte(3, (byte)1);
				ps.executeUpdate();
				ps.close();
				ps=conn.prepareStatement("insert into authorities(username,authority) values(?,?);");
				ps.setString(1, libraryUser.getUsername());
				ps.setString(2, "ROLE_ADMIN");
				ps.executeUpdate();
				ps.close();
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userExists;
	}
	
}



