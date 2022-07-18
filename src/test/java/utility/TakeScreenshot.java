package utility;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class TakeScreenshot {

    // Take a screenshot for full view port and attest to allure report
    @Step("Taking a screenshot for {1}")
    public static void screenshotForAllure(WebDriver driver, String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES)));
    }

}
