import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderSortByPriceAscTest {
    private OrderSortByPrice_ASC orderSortByPriceAsc = new OrderSortByPrice_ASC();
    @Test
    void compareWithSamePrice() {
        Order order1  = new Order(null, null, 10000, null);
        Order order2 = new Order(null, null, 10000, null);
        assertEquals(0, orderSortByPriceAsc.compare(order1, order2));
    }

    @Test
    void compareWithOrderAPriceLowerThanOrderB() {
        Order order1  = new Order(null, null, 99, null);
        Order order2 = new Order(null, null, 100, null);
        assertEquals(-1, orderSortByPriceAsc.compare(order1, order2));
    }

    @Test
    void compareWithOrderAPriceHigherThanOrderB() {
        Order order1  = new Order(null, null, 100, null);
        Order order2 = new Order(null, null, 99, null);
        assertEquals(1, orderSortByPriceAsc.compare(order1, order2));
    }
}