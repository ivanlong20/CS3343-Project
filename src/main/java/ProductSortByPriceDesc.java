public class ProductSortByPriceDesc extends ProductSortType {
    @Override
    public String toString() {
        return "Sort By Price In Descending Order";
    }

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }

}