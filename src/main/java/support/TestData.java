package support;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class TestData {
    private String product;
    private String brand;
    private Integer minPrice;
    private Integer realPrice;
    public TestData(){}

    public TestData(String product, String brand, Integer minPrice) {
        setProduct(product);
        setBrand(brand);
        setMinPrice(minPrice);
    }

    public String getProduct() {
        return product;
    }

    @Attachment("input grop")
    @Step(" setup next data: {product}")
    public void setProduct(String product) {
        this.product = product;
    }

    public String getBrand() {
        return brand;
    }

    @Step(" setup next data: {brand}")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    @Step(" setup next data: {minPrice}")
    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Integer realPrice) {
        this.realPrice = realPrice;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "product='" + product + '\'' +
                ", brand='" + brand + '\'' +
                ", minPrice=" + minPrice +
                ", realPrice=" + realPrice +
                '}';
    }
}
