package page_object_model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DailyDeals {

    public WebDriver driver;

    public DailyDeals(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'col-lg-2') " +
            "and contains(@class, 'col-md-3') " +
            "and contains(@class, 'col-sm-4') " +
            "and contains(@class, 'col-6 mb-3')]")
    List<WebElement> daily_deals_products;

    @Step("Count daily_deals_products")
    public int count_daily_deals_products(){
        return daily_deals_products.size();
    }

}
