package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class step1 {
    private static final long DELAY_IN_MILLIS = 1_000;
    private WebDriver webDriver;

    @Given("User open Cermati with this URL : \"([^\"]*)\"")
    public void openFile (String url) throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--window-size=1366,768");
        chromeOptions.addArguments("--window-position=0,0");
        chromeOptions.addArguments("-- disable-notification");

        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get(url);
        Thread.sleep(DELAY_IN_MILLIS);

    }

    @Given("User Enter Email : \"([^\"]*)\"")
    public void enterEmail (String email) throws InterruptedException {
        WebElement enterUsername = webDriver.findElement(By.xpath("//*[@id=\"email\"]"));
        enterUsername.sendKeys(email);
        Thread.sleep(DELAY_IN_MILLIS);
    }


    @Given("User Enter Kata Sandi : \"([^\"]*)\"")
    public void enterSandi (String sandi) throws InterruptedException {
        WebElement enterUsername = webDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        enterUsername.sendKeys(sandi);
        Thread.sleep(DELAY_IN_MILLIS);
    }

    @Given("User Enter Nama Depan : \"([^\"]*)\"")
    public void enterNamaDepan (String namaDepan) throws InterruptedException {
        WebElement enterUsername = webDriver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        enterUsername.sendKeys(namaDepan);
        Thread.sleep(DELAY_IN_MILLIS);
    }

    @Given("User Enter Nama Belakang : \"([^\"]*)\"")
    public void enterNamaBelakang (String namaBelakang) throws InterruptedException {
        WebElement enterUsername = webDriver.findElement(By.xpath("//*[@id=\"last-name\"]"));
        enterUsername.sendKeys(namaBelakang);
        Thread.sleep(DELAY_IN_MILLIS);
    }


    @Given("User Enter No Telepon : \"([^\"]*)\"")
    public void enterNoTlp (String noTlp) throws InterruptedException {
        WebElement enterUsername = webDriver.findElement(By.xpath("//*[@id=\"mobile-phone\"]"));
        enterUsername.sendKeys(noTlp);
        Thread.sleep(DELAY_IN_MILLIS);
    }


    @Given("User Enter Kabupaten : \"([^\"]*)\"")
    public void enterKabupaten (String kabupaten) throws InterruptedException {
        WebElement enterUsername = webDriver.findElement(By.xpath("//*[@id=\"residence-city\"]"));
        enterUsername.sendKeys(kabupaten);

        WebElement enterKota = webDriver.findElement(By.xpath("//div[text(), \"KOTA BANDUNG\"]"));
        enterKota.click();

        Thread.sleep(DELAY_IN_MILLIS);
    }

    @Given("User Click Daftar Akun button")
    public void signIn () throws InterruptedException {
        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id=\"submit-join\"]"));
        signInButton.click();
        Thread.sleep(DELAY_IN_MILLIS);
    }


    @After("@CloseBrowser")
    public void closeBrowser()
    {
        if(webDriver!=null)
        {
            webDriver.quit();
        }
    }
}
