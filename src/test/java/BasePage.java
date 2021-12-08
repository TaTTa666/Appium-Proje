import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage extends BaseTest{

@Step("<wait> bekleme ")
    public void waitForsecond(int wait) throws InterruptedException {
    Thread.sleep(1000*wait);
    System.out.println(wait + "saniye bekledi !!!!");

}

@Step("<selectorid> click yap")
    public void clickByid(String selectorid){
    appiumDriver.findElement(By.id(selectorid)).click();
    System.out.println(selectorid + "Elementine tıklandır !!!");
}

@Step("<id> id'li elemente <text> text değerini yaz")
    public void sendKeysbyid(String id, String text){
    appiumDriver.findElement(By.id(id)).sendKeys(text);
    System.out.println(text + "Değeri yazıldı !!!");
}
@Step("<key> id'li element <keyword> text değerini içerdiğni kontrol et")
    public void textContol(String key,String keyword){
    Assert.assertFalse("Elementi içermiiyo",appiumDriver.findElement(By.id(key)).getText().contains(keyword));

}
    @Step("<selectorid> xpath'li elemente tıkla")
    public void clickByxPath(String selectorid){
        appiumDriver.findElement(By.xpath(selectorid)).click();
        System.out.println(selectorid + "Elementine tıklandır !!!");
    }

        @Step("sayfayı asagı kaydır")
    public void sayfayıKaydır(){
            int startX = 530;
            int startY = 1950;
            int endX = 531;
            int endY = 354;
            TouchAction action = new TouchAction(appiumDriver);
            action.press(point(startX, startY))
                    .moveTo(point(endX, endY))
                    .release()
                    .perform();

        }
    @Step("<random> random yap")
    public void randomProductClick(String random){
        List<MobileElement> elements = appiumDriver.findElementsById(random);
        Random rnd = new Random();
        int rndInt = rnd.nextInt(elements.size());
        elements.get(rndInt).click();

    }

}
