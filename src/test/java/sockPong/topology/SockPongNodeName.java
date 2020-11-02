package sockPong.topology;

public enum SockPongNodeName {

    EDGE_ROUTER("Edge_Router"),
    FRONTEND_SOFTWARE("Frontend_Software"),
    CATALOGUE_SOFTWARE("Catalogue_Software"),
    ORDERS_SOFTWARE("Orders_Software"),
    CATALOGUE_DB_CONTAINER("Catalogue_DB_Container"),
    ORDERS_DB_CONTAINER("Orders_DB_Container"),
    USERS_SOFTWARE("Users_Software"),
    CARTS_SOFTWARE("Carts_Software"),
    PAYMENT_SOFTWARE("Payment_Software"),
    SHIPPING_SOFTWARE("Shipping_Software"),
    QUEUE_MASTER_CONTAINER("Queue_Master_Container"),
    USERS_DB_CONTAINER("Users_DB_Container"),
    CARTS_DB_CONTAINER("Carts_DB_Container"),
    RABBITMQ_CONTAINER("RabbitMQ_Container");

    private final String value;

    SockPongNodeName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
