import java.util.Comparator;

public abstract class ProductSortType implements Comparator<Product> {
    public abstract int compare(Product p1, Product p2);
}
