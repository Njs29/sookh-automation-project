package page_object_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "d-inline-block")
    List<WebElement> all_color_button;

    @FindBy(xpath = "(//span[normalize-space()='128GB'])[1]")
    WebElement storage1;

    @FindBy(xpath = "(//span[normalize-space()='256GB'])[1]")
    WebElement storage2;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    WebElement dec_item_button;

    @FindBy(xpath = "(//button[@type='button'])[4]")
    WebElement inc_item_button;

    @FindBy(xpath = "//button[normalize-space()='Buy Now']")
    WebElement buy_now_btn;

    public void color_button_click(int index) {
        all_color_button.get(index).click();
    }

    public void storage1_click() {
        storage1.click();
    }

    public void storage2_click() {
        storage2.click();
    }

    public void dec_item_button_click() {
        dec_item_button.click();
    }

    public void inc_item_button_click(int time) {
        for (int i = 0; i < time; i++) {
            inc_item_button.click();
        }
    }

    public void buy_now_btn_click() {
        buy_now_btn.click();
    }


}
