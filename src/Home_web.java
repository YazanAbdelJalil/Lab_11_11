import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Home_web {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.edgedriver.driver", "D:\\edgedriver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		// driver.manage().window().maximize();

		// Date currentDate= new Date();
		// String TheAcutalDate = currentDate.toString().replace(":" , "-");

		// TakesScreenshot src = ((TakesScreenshot)driver);
		// File SrcFile= src.getScreenshotAs((OutputType.FILE));
		// File Dest = new File(".//mypictures/"+TheAcutalDate+".png");
		// FileUtils.copyFile(SrcFile, Dest);

		// driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
		List<WebElement> thestudents = driver.findElements(By.tagName("option"));
		int theTotalNumberOfStudents = thestudents.size();
		System.out.println(theTotalNumberOfStudents + "this is the orginal number");

		int HowMainyItems = 1;
		System.out.println(HowMainyItems+ "this is the number of itemes i have romved");
		for (int i = 0; i < HowMainyItems; i=i++) {
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();

		}
		List<WebElement> thestudentsAfterRemove = driver.findElements(By.tagName("option"));
		int ActualNumber = thestudentsAfterRemove.size();
		System.out.println( "this is the new ActualNumber"+ ActualNumber);

		int expectedITems = theTotalNumberOfStudents - HowMainyItems;
		
		System.out.println(expectedITems + "this is the expectedITems");

		Assert.assertEquals(ActualNumber, expectedITems);

	}

}
