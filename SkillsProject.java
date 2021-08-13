import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SkillsProject {

	static WebDriver driver;

	public void getDriver() {
		driver = DriverSetup.getWebDriver();
	}

	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

	public void navigate() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("menu_admin_viewAdminModule"))).perform();
		action.moveToElement(driver.findElement(By.id("menu_admin_Qualifications"))).perform();
		action.moveToElement(driver.findElement(By.id("menu_admin_viewSkills"))).click().perform();

	}

	public void addSkillName() {
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("skill_name")).sendKeys("Testing Demo");
		driver.findElement(By.id("btnSave")).click();
	}

	public void deleteSkillName() {
		List<WebElement> elements = driver.findElements(By.tagName("tr"));
		for(int i=1;i<elements.size();i++)
			if(driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr["+i+"]/td[2]/a[1]")).getText().equalsIgnoreCase("Testing Demo"))
				driver.findElement(By.xpath("//body[1]/div[1]/div[3]/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr["+i+"]/td[1]/input[1]")).click();
	
		driver.findElement(By.id("btnDel")).click();
		String text = driver.findElement(By.className("fadable")).getText();
		System.out.println(text);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		SkillsProject sp = new SkillsProject();
		sp.getDriver();
		sp.login();
		sp.navigate();
		sp.addSkillName();
		sp.deleteSkillName();
		driver.close();
	}

}
