package trohardelivery.entity;

import java.util.HashMap;

abstract class Food{
    //TODO: КАКВО трябва да значи продукт в този смисъл
    protected String product;
    protected String code;
    protected float price;
    protected int quantity;

    private final static HashMap<String, String> information = new HashMap<>();

    protected Food(String product, String code, float price, int quantity) {
        this.product = product;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    protected void setProduct(String product) {
        this.product = product;
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

    protected void setInfo(String productInformation)
    {
        information.put(this.product, productInformation);
    }

    public String getProductInfo(){
        if(information.containsKey(product)){
        return information.get(product);
        }
        else{
            return "Няма информация за такъв продукт";
        }
    }

    protected void removeProduct(String pName)
    {
        if(pName.equals(product) && information.containsKey(pName)){
            information.remove(pName);
        }
        else{
            System.err.println("Не съществува такъв продукт за премахване!");
        }
    }
}

