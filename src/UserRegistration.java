import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserRegistration {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Anteneh/OWASP ZAP/webdriver/windows/32/chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        //Maximize window      
        driver.manage().window().maximize();

        //Launch the Site.      
        driver.get("https://demowebshop.tricentis.com/register");

        //Enter values into form and submit
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("anteneh");
        driver.findElement(By.id("LastName")).sendKeys("solomon");
        driver.findElement(By.id("Email")).sendKeys("antynjasfs@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

        driver.findElement(By.id("register-button")).click();

        String result = driver.findElement(By.className("validation-summary-errors")).getText();

        if( result.equals("The specified email already exists") ) {
            System.out.println("Test Success");
        } else {
            System.out.println("Test Failed");
        }



        //Close the browser
        driver.quit();
    }
}