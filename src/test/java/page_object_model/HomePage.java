package page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search")
    WebElement search_input;

    @FindBy(id = "new-search-button")
    WebElement search_btn;

    @FindBy(xpath = "(//a[normalize-space()='Daily Deals'])[2]")
    WebElement daily_deals;


    public void search(String search_value){
        search_input.sendKeys(search_value);
    }

    public  void search_btn_click(){
        search_btn.click();
    }

    public void daily_deals_click(){
        daily_deals.click();
    }











}
