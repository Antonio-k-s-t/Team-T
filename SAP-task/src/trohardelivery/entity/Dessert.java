package trohardelivery.entity;

class Dessert extends Food {
    //TO DO: Запълване със стойности
    enum DessertSubcategory{

    }
    private final DessertSubcategory subcat;
    public Dessert(String product, String code, float price, int quantity, DessertSubcategory subcat) {
        super(product, code, price, quantity);
        this.subcat = subcat;
    }

    public String getProductType()
    {
        return subcat.name();
    }
}
