class Salad extends Food {
    //TO DO: Запълване със стойности
    enum SaladSubcategory{

    }
    private final SaladSubcategory subcat;
    public Salad(String product, String code, float price, int quantity, SaladSubcategory subcat) {
        super(product, code, price, quantity);
        this.subcat = subcat;
    }

    public String getProductType()
    {
        return subcat.name();
    }
}
