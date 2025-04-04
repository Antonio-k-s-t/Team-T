class MainDish extends Food{
    //TO DO: Запълване със стойности
    enum MainDishSubcategory{
        
    }
    private final MainDishSubcategory subcat;
    public MainDish(String product, String code, float price, int quantity, MainDishSubcategory subcat) {
        super(product, code, price, quantity);
        this.subcat = subcat;
    }

    public String getProductType()
    {
        return subcat.name();
    }
}

