import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

/**
 * Created by Art on 24.11.2017.
 */
public class Test1 {
    @Test
    public void mainTest() throws InterruptedException, MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//
        // Переход в полный экран
        driver.manage().window().maximize();
        // Переход в Яндекс, используя драйвер
        driver.get("https://www.yandex.ru");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Маркет
        WebElement element;
        element = driver.findElement(By.cssSelector("a.home-link[data-id=market]"));
        element.click();
        System.out.println(driver.getTitle());
        //Компьютеры

        element = driver.findElement(By.cssSelector("body > div.main > div.topmenu.i-bem.topmenu_js_inited > noindex > ul > li:nth-child(2) > a"));
        element.click();
        //Планшеты
        element = driver.findElement(By.cssSelector("body > div.main > div:nth-child(4) > div.layout-grid__col.layout-grid__col_width_2 > div > div:nth-child(1) > div > a:nth-child(1)"));
        element.click();
        //Ко всем фильтрам
        element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/div[2]/div/div[30]/div[2]/a"));
        element.click();
        // от 20 000 до 25 000
        element = driver.findElement(By.xpath("//*[@id='glf-pricefrom-var']"));
        element.sendKeys("20000"); // от 20 000
        element = driver.findElement(By.xpath("//*[@id='glf-priceto-var']"));
        element.sendKeys("50000"); // до 50 000
        //Все производители
        element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[1]/div[2]/div[2]/div/div[2]/button"));
        element.click();
        // Выбор Aser и dell
        element = driver.findElement(By.xpath("//*[@for='glf-7893318-267101']")); // Aser
        element.click();
        element = driver.findElement(By.xpath("//body/div[1]/div[4]/div/div[1]/div[1]/div[2]/div[2]/div/span/span/input")); // Ввод Dell
        element.sendKeys("Dell", ENTER);
        element.sendKeys(Keys.TAB, Keys.SPACE);

        //element = driver.findElement(By.xpath("//*[@for='glf-7893318-153080']")); // Dell
        element.click();
        //Подобрать
        element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[4]/a[2]")); // Подбор
        element.click();
        // Подсчет элемнтов //input[@id='passwd-id']"
        List<WebElement> list  = driver.findElements(By.className("n-snippet-card2__title")); // / n-snippet-card2__header// /html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[3]
        System.out.println(list.size());
        Assert.assertEquals(12,list.size());
        // Первый элемент в списке
        element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[1]/div[2]/div/div[1]/div[1]/div[4]/div[1]/div/a"));
        String name1 = element.getText();
        name1 = name1.substring(8);
        //Поиск товара
        element = driver.findElement(By.id("header-search"));
        element.sendKeys("\"" + name1 + "\"");
        element.sendKeys(ENTER);
        //Проверка наименования
        element = driver.findElement(By.cssSelector("h1.title.title_size_28.title_bold_yes"));
        String name2 = element.getText();
        Assert.assertEquals(name1,name2);


        // Закрываем браузер
        driver.quit();

    }
}

