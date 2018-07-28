package runner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4JwithJDBC {
	

public static final Logger logger = LogManager.getLogger();
	
	@Test
	public void getRecordsCount() {
		logger.info("establishing database");
 
		
		try(Connection connection = DriverManager.getConnection(ConfigurationReader.getProperty("oracledb.url"), "hr", "hr");
			Statement statement = connection.createStatement();
			ResultSet resultSet  = statement.executeQuery("Select * from employees");
				)
		{
			logger.debug("Executing query: Select * from employees agains");
			logger.info(ConfigurationReader.getProperty("oracledb.url"), "User: hr", "Password: hr");
			resultSet.last();
}
	}
}
	 