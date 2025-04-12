package trohardelivery.entity;

import java.util.HashMap;

abstract class Food{
    protected String productName;
    protected String code;
    protected float price;
    protected int quantity;

    protected Food(String productName, String code, float price, int quantity) {
        this.productName = productName;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProduct() {
        return productName;
    }

    protected void setProduct(String productName) {
        this.productName = productName;
    }

    public String getCode() {
        return code;
    }

    protected void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    protected void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

