import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaymentIntegration {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Anteneh/OWASP ZAP/webdriver/windows/32/chromedriver.exe");

        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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


        list2.get(1).click();
        list2.get(2).click();

        driver.findElement(By.xpath("//li[@id='topcartlink']")).click();


        driver.findElement(By.id("termsofservice")).click();

        driver.findElement(By.xpath("//button[@value='checkout']")).click();

        List<WebElement> listcontinue =driver.findElements(By.xpath("//input[@value='Continue']"));

        System.out.println(listcontinue.size());
        listcontinue.get(0).click();
        listcontinue.get(1).click();

        driver.findElement(By.id("shippingoption_0")).click();

        listcontinue.get(2).click();

        driver.findElement(By.id("paymentmethod_2")).click();
        listcontinue.get(3).click();

        driver.findElement(By.id("CardholderName")).sendKeys("anteneh solomon");
        driver.findElement(By.id("CardNumber")).sendKeys("4111 1111 1111 1111");
        driver.findElement(By.id("CardCode")).sendKeys("737");

        listcontinue.get(4).click();

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();

        String result = driver.findElement(By.className("title")).getText();

        System.out.println(result);

        if( result.equals("Your order has been successfully processed!") ) {
            System.out.println("Test Success");
        } else {
            System.out.println("Test Failed");
        }



        //Close the browser
        //driver.quit();
    }
}