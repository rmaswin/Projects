package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Saucedemo {
	WebDriver driver;
	@Test(dataProvider="testdata")
	public void sauce(String username, String password)
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\rmasw\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.name("user-name")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login-button")).click();
		Select Dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
		Dropdown.selectByIndex(2);
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]")).click();
		driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
		driver.findElement(By.name("remove-sauce-labs-backpack")).click();
		driver.findElement(By.name("remove-sauce-labs-fleece-jacket")).click();
		driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		driver.findElement(By.name("firstName")).sendKeys("RM");
		driver.findElement(By.name("lastName")).sendKeys("ASWIN");
		driver.findElement(By.id("postal-code")).sendKeys("695584");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		
	}
	@DataProvider(name="testdata")
	public Object[] [] testDataFeed()
	{
		ReadExcelFile config=new ReadExcelFile("C:\\Users\\rmasw\\OneDrive\\Desktop\\saucedemo.xlsx");
		int rows=config.getRowCount(0);
		Object[][] credntls=new Object[rows][2];
		for(int i=0;i<rows;i++)
		{
			credntls[i][0]=config.getData(0,i,0);
			credntls[i][1]=config.getData(0,i,1);
		}
		return credntls;
	}
}
