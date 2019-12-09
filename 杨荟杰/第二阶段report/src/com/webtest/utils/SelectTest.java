package com.webtest.utils;

import java.io.File;

import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectTest {
	public static void main(String[] args){
		WebDriver driver = new  ChromeDriver();
        File file = new File("http://localhost/ranzhi/www/cash/index.php?m=trade&f=create&type=in");
        String filePath = file.getAbsolutePath();
        driver.get(filePath);
        
         String js = "document.querySelectorAll('select')[0].style.display='block';";
        ((JavascriptExecutor)driver).executeScript(js);
        
        Select sel = new Select(driver.findElement(ById.xpath("//select")));
        sel.selectByValue("opel");
	}

}
