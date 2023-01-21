import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Napraviti maven projekat i dodati selenium dependency.
U Mainu preko selenijuma otici na https://demoqa.com/text-box.

Zadatak je da popunite sva polja (Full Name, email, Current Address, Permanent Address) i da kliknete submit.

Uporediti da li u rezultatu (ispod submit), full name i email su isti kao uneseni pre submita, da nije doslo do izmene. Upisati odgovarajucu poruku ako su isti ili ako se razlikuju podaci.

 */
public class Zadatak1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ivan\\Documents\\IT Bootcamp\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        Faker faker = new Faker();

        WebElement userName = driver.findElement(By.id("userName"));
        String fullName = "Katarina Ljubinkovic";
        userName.sendKeys(fullName);

        WebElement emailAddress = driver.findElement(By.id("userEmail"));
        String email = "katarinaljubinkovic@gmail.com";
        emailAddress.sendKeys(email);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(faker.address().fullAddress());

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,600);", "");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys(faker.address().fullAddress());

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

//POREĐENJE STRINGOVA
                                //uklanjanje belina u Stringu između reči
        //String nameWithoutSpace = name.replaceAll("\\s", "");  //IZGUGLALA
        //String nameModified = nameWithoutSpace.toLowerCase();

        //String emailSub = email.substring(0, 15);

        //if (nameModified.equals(emailSub)) {
            //System.out.println("Imena iz polja fullName i emailAddress su ista.");
        //} else {
           // System.out.println("Imena iz polja fullName i emailAddress su različita.");
        //}

        WebElement name1 = driver.findElement(By.id("name"));
        WebElement email1 = driver.findElement(By.id("email"));

        String name = name1.getText().toLowerCase();
        System.out.println(name);
        String namee = name.substring(5);
        System.out.println(namee);
        String nameee = namee.replaceAll("\\s", "");
        System.out.println(nameee);

        String eMail = email1.getText().substring(6, name.length());
        System.out.println(eMail);



        if (nameee.equals(eMail)) {
            System.out.println("Imena iz polja fullName i emailAddress su ista.");
        } else {
            System.out.println("Imena iz polja fullName i emailAddress su različita.");
        }
    }
}