import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginThree {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Anteneh/OWASP ZAP/webdriver/windows/32/chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        //Maximize window
        driver.manage().window().maximize();

        //Launch the Site.
        driver.get("https://demowebshop.tricentis.com/login");

        //Enter values into form and submit
        driver.findElement(By.id("Email")).sendKeys("tedban@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("RememberMe")).click();

        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        String result = driver.findElement(By.className("validation-summary-errors")).getText();
        System.out.println(result);

        if( result.equals("Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found") ) {
            System.out.println("Test Success");
        } else {
            System.out.println("Test Failed");
        }



        //Close the browser
        driver.quit();
    }
}