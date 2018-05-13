package ex1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class C3p0Test {
	public static void main(String[] args) {
		ComboPooledDataSource cds = new ComboPooledDataSource();
		cds.setUser("root");
		cds.setPassword("shix");
		cds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		// TODO Auto-generated method stub
		// 启动数据库
		Connection conn = null;
		// 对象
		Statement stmt = null;
		ResultSet res = null;
		try {
			conn = cds.getConnection();
			// 输入sql
			String sql = "select * from t_user";
			stmt = conn.createStatement();
			res = stmt.executeQuery(sql);
			while (res.next()) {
				System.out.println(res.getInt("id") + "\t" + res.getString("name") + "\t" + res.getInt("age") + "\t"
						+ res.getDate("birthday"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6 关闭： 先告诉Statement说话， 再断开连接
			cds.close();

		}

	}
}
