import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageFactory.BucketPage;
import pageFactory.BusinessLogic;
import pageFactory.SearchPage;
import pageFactory.StartPage;
import support.PropertiesReader;
import support.TestData;
import support.XmlTestData;

//@ExtendWith(TestListenerFailScreen.class)
@Listeners(ConvertTestListener.class)
public class FirstCaseTest extends BaseTest {

    final static Logger logger = Logger.getLogger(FirstCaseTest.class);
    PropertiesReader properties = new PropertiesReader();
    TestData testData = XmlTestData.ReadXml(properties.getInitialData());

    final String description1 = "run one test from file testData.xml";
    @Owner("Alex I")
    @Description(description1)
    @Test (description = description1 )
    public void checkExpensiveGoods() {
        testFlow(testData.getProduct(), testData.getBrand(), testData.getMinPrice());
    }

    final String description = "input hard coding data";
    @Test (description = description )
    @Owner("Alex I")
    @Description(description)
    public void checkExpensiveGood() {
        String[] data = {"Ноутбук", "MSI" };
        int priceAssert = 5000;
        testFlow(data[0], data[1], priceAssert);
    }


    private void testFlow(String product, String brand, Integer minPrice) {
        StartPage startPage = getStartPage();
        startPage.searchByKeyword(product);
        TestData testData = new TestData(product, brand, minPrice);
        SearchPage searchPage = getSearchPage();
        new BusinessLogic().addToBucketExpensiveElementNoThreadSleep(searchPage, brand);
        BucketPage bucketPage = getBucketPage();
        new BusinessLogic().CheckProduct(bucketPage, testData);
        logger.info("Test work!");
    }

    @Test (description = "test is ignored because test work data")
    public void checkExpensiveGood2() {
        String[] data = {"стиральная машина", "Samsung" };
        int priceAssert = 14000;
        testFlow(data[0], data[1], priceAssert);
    }
}
