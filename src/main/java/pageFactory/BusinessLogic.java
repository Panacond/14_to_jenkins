package pageFactory;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import support.PropertiesReader;
import support.TestData;

import java.util.List;

import static support.XmlTestData.WriteXml;

public class BusinessLogic {
    PropertiesReader properties = new PropertiesReader();

    public void addToBucketExpensiveElementNoThreadSleep(SearchPage searchPage, String brand) {
        searchPage.clickCheckBoxMsi(brand);
        searchPage.implicitWait(10);
        searchPage.clickPopUpByText(" От дорогих к дешевым ");
        searchPage.implicitWait(30);
        List<WebElement> listAddToBucket =  searchPage.getListAddToBucket();
        searchPage.waitVisibilityOfElement(40, listAddToBucket.get(0));
        searchPage.waitClickOfElement(80,listAddToBucket.get(0));
        listAddToBucket.get(0).click();
        searchPage.clickGoToBucket();
    }

    public void CheckProduct(BucketPage bucketPage, TestData testData){
        Integer price = bucketPage.getStringPrice();
        testData.setRealPrice(price);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(price > testData.getMinPrice(), "Price in page low data price" + price + ">" + testData.getMinPrice() + "???");
        softAssert.assertAll();
        WriteXml(testData, properties.getResultListData());
    }
}
