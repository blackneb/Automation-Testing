import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WishlistTwo {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Anteneh/OWASP ZAP/webdriver/windows/32/chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Maximize window
        driver.manage().window().maximize();

        //Launch the Site.
        driver.get("https://demowebshop.tricentis.com/login");

        //Enter values into form and submit
        driver.findElement(By.id("Email")).sendKeys("ant12@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("RememberMe")).click();

        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        List<WebElement> list2 =driver.findElements(By.xpath("//input[@value='Add to cart']"));


        list2.get(0).click();

        driver.findElement(By.id("giftcard_2_RecipientName")).sendKeys("anteneh solomon");
        driver.findElement(By.id("giftcard_2_RecipientEmail")).sendKeys("");

        driver.findElement(By.xpath("//input[@id='add-to-wishlist-button-2']")).click();

        String result = driver.findElement(By.className("content")).getText();

        if( result.equals("Enter valid recipient email") ) {
            System.out.println("Test Success");
        } else {
            System.out.println("Test Failed");
        }

        //Close the browser
        //driver.quit();
    }
}