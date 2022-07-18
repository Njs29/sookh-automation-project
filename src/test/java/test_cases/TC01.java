package test_cases;

import base.BaseDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page_object_model.*;

import static utility.TakeScreenshot.screenshotForAllure;

public class TC01 extends BaseDriver {

    @Test
    public void tc01() throws InterruptedException {
        driver.get("https://www.sookh.com/");
        HomePage home = new HomePage(driver);
        SearchResultPage result = new SearchResultPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CompleteOrderPage order = new CompleteOrderPage(driver);
        SoftAssert soft_assert = new SoftAssert();

        home.search("smartphone");
        home.search_btn_click();

        String expected_title = "SOOKH | Product Search Result for smartphone | SOOKH";
        soft_assert.assertEquals(driver.getTitle(), expected_title);

        result.product_name_click(1);

        product.color_button_click(1);
        //product.storage2_click();
        product.inc_item_button_click(2);
        product.buy_now_btn_click();

        cart.checkout_btn_click();

        order.set_name("abc");
        order.set_phone("01974656345");

        order.division_click();
        order.search_select(actions, "khulna");

        order.district_click();
        order.search_select(actions, "kushtia");

        order.area_click();
        order.search_select(actions, "mirpur");

        order.set_postal_code("1230");

        order.set_address("abd xyz");

        order.scroll_to_payment_selection(driver);
        order.cod_click();
        order.bkash_click();

        //order.agree_checkbox_click();
        Thread.sleep(5000);

        order.complete_order_btn_click();

        String current_url = driver.getCurrentUrl();
        soft_assert.assertTrue(current_url.contains("bkash/payment"));
        Thread.sleep(3000);
        screenshotForAllure(driver, "Bkash page screenshot");

        soft_assert.assertAll();


    }

}

