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
		// �������ݿ�
		Connection conn = null;
		// ����
		Statement stmt = null;
		ResultSet res = null;
		try {
			conn = cds.getConnection();
			// ����sql
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
			// 6 �رգ� �ȸ���Statement˵���� �ٶϿ�����
			cds.close();

		}

	}
}
