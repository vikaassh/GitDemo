package Test.Database_Testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class jdbcconnection {
	
		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			// TODO Auto-generated method stub
			
			
			String url="jdbc:mysql://localhost:3306/demo?useSSL=false&allowPublicKeyRetrieval=true";
			String username="root";
			String password="2820";
			
			Connection con = DriverManager.getConnection(url, username, password);
		
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery("select * from credentials where scanario ='zerobalancecard';");
			
			while(rs.next())
			{
			
			System.setProperty("webdriver.chrome.driver", "F:\\Database_Testing\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			driver.get("https://login.salesforce.com");
			
			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
			}

		}

	}

