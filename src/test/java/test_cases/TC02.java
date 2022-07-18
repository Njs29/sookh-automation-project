package test_cases;

import base.BaseDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page_object_model.DailyDeals;
import page_object_model.HomePage;

public class TC02 extends BaseDriver {

    @Test
    public void tc02(){
        HomePage home = new HomePage(driver);
        DailyDeals daily_deals = new DailyDeals(driver);
        SoftAssert soft_assert = new SoftAssert();

        driver.get("https://www.sookh.com/");
        home.daily_deals_click();

        String expected_url = "sookh.com/daily-deals";
        String actual_url = driver.getCurrentUrl();
        soft_assert.assertTrue(actual_url.contains(expected_url));

        int expected_product_count = 12;
        int count_products = daily_deals.count_daily_deals_products();

        soft_assert.assertEquals(expected_product_count, count_products);

        soft_assert.assertAll();

    }

}
