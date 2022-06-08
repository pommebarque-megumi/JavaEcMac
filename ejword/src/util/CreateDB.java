package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDB {
	public static void main(String[] args) {
		try {
			//フィル読み込み(fis/fos)
			FileInputStream fis = new FileInputStream("assets/ejdic-hand-utf8.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			//データソースを利用せず、ダイレクトにデータベースに接続
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ejword?useUnicode=true&characterEncoding=utf8";
			String user ="root";
			String pass = "";
			Connection db = DriverManager.getConnection(url,user,pass);

			//トランザクション処理開始
			db.setAutoCommit(false);
			PreparedStatement ps = db.prepareStatement("INSERT INTO words(title,body) VALUES(?,?)");
			String line;
			while((line = br.readLine()) != null) {
				String[] vals = line.split("\t");
				ps.setString(1, vals[0]);
				ps.setString(2, vals[1]);
				ps.executeUpdate();
			}
			db.commit();
			db.close();
			br.close();
			System.out.println("OK");
		} catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
