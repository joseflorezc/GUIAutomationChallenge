import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.steps.ReadData;

import java.io.IOException;

public class Hooks {

    protected WebDriver driver;
    protected String apiKey;
    protected String username;
    protected String password;
    protected String domain;

    @BeforeMethod
    public void setup() throws IOException {
        String [] credentials = ReadData.readData("src/test/resources/credentials/Credentials.txt");
        username = credentials[0];
        password = credentials[1];
        apiKey = credentials[2];
        domain = "https://api.themoviedb.org/3";
        driver = new ChromeDriver();
        driver.navigate().to("https://www.themoviedb.org/");
        //Es necesario establecer el tamanio, para que no se rompa el test,
        // ya que con paginas responsive los componentes pueden cambiar completamente
        driver.manage().window().maximize();



    }

    @AfterMethod
    public void exit(){
//        driver.quit();

    }




}
