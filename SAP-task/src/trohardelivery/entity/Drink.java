package trohardelivery.entity;

class Drink extends Food {
    //TODO: Запълване със стойности
    enum DrinkSubcategory{

    }
    private final DrinkSubcategory subcat;
    public Drink(String product, String code, float price, int quantity, DrinkSubcategory subcat) {
        super(product, code, price, quantity);
        this.subcat = subcat;
    }

    public String getProductType()
    {
        return subcat.name();
    }
}

