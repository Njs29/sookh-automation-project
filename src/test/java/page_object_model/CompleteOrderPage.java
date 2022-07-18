package page_object_model;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utility.CommonMethod.scrollToElement;

public class CompleteOrderPage {

    public WebDriver driver;

    public CompleteOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "name")
    WebElement name_input;

    @FindBy(id = "address_phone_no") //@FindBy(name = "phone")
    WebElement phone_input;

    @FindBy(xpath = "//span[contains(@class, 'select2-selection') and contains(@class, 'select2-selection--single')]")
    List<WebElement> all_select;

    @FindBy(className = "select2-search__field")
    WebElement select_search_input;

    @FindBy(name = "postal_code")
    WebElement postal_code_input;

    @FindBy(name = "address")
    WebElement address_input;

    @FindBy(id = "profile-tab")
    WebElement cod;

    @FindBy(xpath = "//div[contains(@class, 'payment-selection mt-3 col-md-12')]")
    WebElement payment_selection;

    @FindBy(xpath = "(//a[@id='nogod-tab'])[2]")
    WebElement bkash;

    @FindBy(id = "agree_checkbox")
    WebElement agree_checkbox;

    @FindBy(xpath = "//button[normalize-space()='Complete Order']")
    WebElement complete_order_btn;

    @Step("Set name input")
    public void set_name(String name) {
        name_input.sendKeys(name);
    }

    @Step("Set phone input")
    public void set_phone(String phone) {
        phone_input.sendKeys(phone);
    }

    @Step("Click on division dropdown")
    public void division_click() {
        all_select.get(0).click();
    }

    @Step("Click on district dropdown")
    public void district_click() {
        all_select.get(1).click();
    }

    @Step("Click on area dropdown")
    public void area_click() {
        all_select.get(2).click();
    }

    public void search_select(Actions actions, String value) {
        actions.moveToElement(select_search_input).click()
                .sendKeys(value)
                .sendKeys(Keys.ENTER)
                .build().perform();
    }

    public void set_postal_code(String postal_code) {
        postal_code_input.sendKeys(postal_code);
    }

    public void set_address(String address) {
        address_input.sendKeys(address);
    }

    public void cod_click() {
        cod.click();
    }

    public void scroll_to_payment_selection(WebDriver driver){
        scrollToElement(payment_selection, driver);
    }

    public void bkash_click() {
        bkash.click();
    }

    public void agree_checkbox_click() {
        agree_checkbox.click();
    }

    public void complete_order_btn_click() {
        complete_order_btn.click();
    }


}
