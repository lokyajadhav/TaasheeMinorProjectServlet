package TaasheeTraining.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
private static ConnectionFactory connfac=new ConnectionFactory();
private String URL="jdbc:mysql://localhost:3306/taahseetraininginstitute";
private String USER="root";
private String PASSWORD="Loky@9985";
public ConnectionFactory()
{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	}catch (Exception e)
	{
		e.printStackTrace();
	}
}
private Connection fetchConnection()
{
	Connection con=null;
	try
	{
		con=DriverManager.getConnection(URL, USER, PASSWORD);
		
		
	}catch (SQLException e)
	{
		e.printStackTrace();
	}
	return con;
}
public static Connection getConnection()
{
	return connfac.fetchConnection();
}

}
