import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderSortByTransactionIDDescTest {
    OrderSortByTransactionID_DESC orderSortByTransactionIDDesc = new OrderSortByTransactionID_DESC();

    @Test
    void compareWithProductANameSmallerThanProductB() {
        Order order1 = new Order(null, null, 1000, null);
        Order order2 = new Order(null, null, 1000, null);
        assertEquals(1, orderSortByTransactionIDDesc.compare(order1, order2));
    }

    @Test
    void compareWithTransactionIDOrderALargerThanOrderB() {
        Order order1 = new Order(null, null, 1000, null);
        Order order2 = new Order(null, null, 1000, null);
        assertEquals(-1, orderSortByTransactionIDDesc.compare(order2, order1));
    }
}