package Organization;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Org1{
	public static void main(String[] args) throws Throwable {
//git
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		FileInputStream fis = new FileInputStream("./src\\test\\resources\\practisepp.properties.txt");
		Properties p = new Properties();
		p.load(fis);
		

		String URL=p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");

		

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		Random ran = new Random();
		int randum = ran.nextInt();

		FileInputStream fis1=new FileInputStream("./src\\test\\resources\\practise.xlsx");
        Workbook book = WorkbookFactory.create(fis);
        Sheet sheet = book.getSheet("Sheet1");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(0);
        cell.getStringCellValue();
		
		driver.findElement(By.name("accountname")).sendKeys("hgft14"+randum);
		driver.findElement(By.id("phone")).sendKeys("37837823");
		driver.findElement(By.id("email1")).sendKeys("abc@gmail.com");


		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//driver.switchTo().alert().accept();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
