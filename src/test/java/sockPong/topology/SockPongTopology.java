package sockPong.topology;

import canalyzer.utilities.pong.PongGenerator;
import model.Application;
import model.Node;
import model.PiVersion;
import model.StaticBinding;

import java.util.ArrayList;
import java.util.List;

public class SockPongTopology {
    public static Application sockPongTopology() {

        // Sock Shop topology created with Pong Node

        // Application
        Application topologyApp = new Application("sockPong", PiVersion.GREEDYPI);

//----------------------------------------------------------------------------------------------------------------------
//------------------------------------------Node------------------------------------------------------------------------

        // Edge_Router
        ArrayList<String> edgeRouterReq = new ArrayList<>(List.of(SockPongReqCap.CONN.toString()));
        Node edgeRouter =PongGenerator.createPongNode(SockPongNodeName.EDGE_ROUTER.toString(), edgeRouterReq);
        topologyApp.addNode(edgeRouter);

        // Fronted_Software
        ArrayList<String> frontendReq = new ArrayList<>(List.of("connCatalogue", "connUsers", "connCarts", "connOrders"));
        Node frontendSoftware = PongGenerator.createPongNode(SockPongNodeName.FRONTEND_SOFTWARE.toString(), frontendReq);
        topologyApp.addNode(frontendSoftware);

        // Catalogue_Software
        ArrayList<String> catalogueReq = new ArrayList<>(List.of(SockPongReqCap.CONN.toString()));
        Node catalogueSoftware = PongGenerator.createPongNode(SockPongNodeName.CATALOGUE_SOFTWARE.toString(), catalogueReq);
        topologyApp.addNode(catalogueSoftware);

        // Orders_Software
        ArrayList<String> ordersReq = new ArrayList<>(List.of("connUsers","connCarts","connPayment","connShipping","connOrdersDb"));
        Node ordersSoftware = PongGenerator.createPongNode(SockPongNodeName.ORDERS_SOFTWARE.toString(), ordersReq);
        topologyApp.addNode(ordersSoftware);

        // Catalogue_DB_Container
        Node catalogueDbContainer = PongGenerator.createPongNode(SockPongNodeName.CATALOGUE_DB_CONTAINER.toString(), new ArrayList<>());
        topologyApp.addNode(catalogueDbContainer);

        // Orders_DB_Container
        Node ordersDbContainer = PongGenerator.createPongNode(SockPongNodeName.ORDERS_DB_CONTAINER.toString(), new ArrayList<>());
        topologyApp.addNode(ordersDbContainer);

        // Users_Software
        ArrayList<String> usersReq = new ArrayList<>(List.of(SockPongReqCap.CONN.toString()));
        Node usersSoftware = PongGenerator.createPongNode(SockPongNodeName.USERS_SOFTWARE.toString(), usersReq);
        topologyApp.addNode(usersSoftware);

        // Carts_Software
        ArrayList<String> cartsReq = new ArrayList<>(List.of(SockPongReqCap.CONN.toString()));
        Node cartsSoftware = PongGenerator.createPongNode(SockPongNodeName.CARTS_SOFTWARE.toString(), cartsReq);
        topologyApp.addNode(cartsSoftware);

        // Payment_Software
        Node paymentSoftware = PongGenerator.createPongNode(SockPongNodeName.PAYMENT_SOFTWARE.toString(), new ArrayList<>());
        topologyApp.addNode(paymentSoftware);

        // Shipping_Software
        ArrayList<String> shippingReq = new ArrayList<>(List.of(SockPongReqCap.CONN.toString()));
        Node shippingSoftware = PongGenerator.createPongNode(SockPongNodeName.SHIPPING_SOFTWARE.toString(), shippingReq);
        topologyApp.addNode(shippingSoftware);

        // Queue_Master_container
        ArrayList<String> queueMasterReq = new ArrayList<>(List.of(SockPongReqCap.CONN.toString()));
        Node queueMasterContainer = PongGenerator.createPongNode(SockPongNodeName.QUEUE_MASTER_CONTAINER.toString(), queueMasterReq);
        topologyApp.addNode(queueMasterContainer);

        // Users_DB_Container
        Node usersDbContainer = PongGenerator.createPongNode(SockPongNodeName.USERS_DB_CONTAINER.toString(), new ArrayList<>());
        topologyApp.addNode(usersDbContainer);

        // Carts_DB_Container
        Node cartsDbContainer = PongGenerator.createPongNode(SockPongNodeName.CARTS_DB_CONTAINER.toString(), new ArrayList<>());
        topologyApp.addNode(cartsDbContainer);

        // RabbitMQ_Container
        Node rabbitMqContainer = PongGenerator.createPongNode(SockPongNodeName.RABBITMQ_CONTAINER.toString(), new ArrayList<>());
        topologyApp.addNode(rabbitMqContainer);

//----------------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------
//------------------------------------------Static Binding--------------------------------------------------------------

        // Edge Router--------------------------------------------------------------------------------------------------

        // Edge_router -> Frontend_Software
        StaticBinding edgeRouterToFrontend = new StaticBinding(SockPongNodeName.EDGE_ROUTER.toString(), SockPongReqCap.CONN.toString());
        StaticBinding frontendToEdgeRouter = new StaticBinding(SockPongNodeName.FRONTEND_SOFTWARE.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(edgeRouterToFrontend, frontendToEdgeRouter);

        //--------------------------------------------------------------------------------------------------------------

        // Frontend-----------------------------------------------------------------------------------------------------

        // Frontend_Software -> Catalogue_Software
        StaticBinding frontendToCatalogue = new StaticBinding(SockPongNodeName.FRONTEND_SOFTWARE.toString(), "connCatalogue");
        StaticBinding catalogueToFrontend = new StaticBinding(SockPongNodeName.CATALOGUE_SOFTWARE.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(frontendToCatalogue, catalogueToFrontend);

        // Frontend_Software -> Users_Software
        StaticBinding frontendToUsers = new StaticBinding(SockPongNodeName.FRONTEND_SOFTWARE.toString(), "connUsers");
        StaticBinding usersToFrontend = new StaticBinding(SockPongNodeName.USERS_SOFTWARE.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(frontendToUsers, usersToFrontend);

        // Frontend_Software -> Carts_Software
        StaticBinding frontendToCarts = new StaticBinding(SockPongNodeName.FRONTEND_SOFTWARE.toString(), "connCarts");
        StaticBinding cartsToFrontend = new StaticBinding(SockPongNodeName.CARTS_SOFTWARE.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(frontendToCarts, cartsToFrontend);

        // Frontend_Software -> Orders_Software
        StaticBinding frontendToOrders = new StaticBinding(SockPongNodeName.FRONTEND_SOFTWARE.toString(),"connOrders" );
        StaticBinding ordersToFrontend = new StaticBinding(SockPongNodeName.ORDERS_SOFTWARE.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(frontendToOrders, ordersToFrontend);

        //--------------------------------------------------------------------------------------------------------------


        //Catalogue-----------------------------------------------------------------------------------------------------

        // Catalogue_Software -> Catalogue_DB_Container
        StaticBinding catalogToDB = new StaticBinding(SockPongNodeName.CATALOGUE_SOFTWARE.toString(), SockPongReqCap.CONN.toString());
        StaticBinding dbToCatalogue = new StaticBinding(SockPongNodeName.CATALOGUE_DB_CONTAINER.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(catalogToDB, dbToCatalogue);

        //--------------------------------------------------------------------------------------------------------------

        //Orders--------------------------------------------------------------------------------------------------------

        // Orders_Software -> Users_Software
        StaticBinding ordersToUsers = new StaticBinding(SockPongNodeName.ORDERS_SOFTWARE.toString(), "connUsers");
        StaticBinding usersToOrders = new StaticBinding(SockPongNodeName.USERS_SOFTWARE.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(ordersToUsers,usersToOrders);

        // Orders_Software -> Orders_DB_Container
        StaticBinding ordersToDb = new StaticBinding(SockPongNodeName.ORDERS_SOFTWARE.toString(), "connOrdersDb");
        StaticBinding dbToOrders = new StaticBinding(SockPongNodeName.ORDERS_DB_CONTAINER.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(ordersToDb, dbToOrders);

        // Orders_Software -> Carts_Software
        StaticBinding ordersToCarts = new StaticBinding(SockPongNodeName.ORDERS_SOFTWARE.toString(),"connCarts" );
        StaticBinding cartsToOrders = new StaticBinding(SockPongNodeName.CARTS_SOFTWARE.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(ordersToCarts, cartsToOrders);

        // Orders_Software -> Payment_Software
        StaticBinding ordersToPayment = new StaticBinding(SockPongNodeName.ORDERS_SOFTWARE.toString(), "connPayment");
        StaticBinding paymentToOrders = new StaticBinding(SockPongNodeName.PAYMENT_SOFTWARE.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(ordersToPayment, paymentToOrders);

        // Orders_Software -> Shipping_Software
        StaticBinding ordersToShipping = new StaticBinding(SockPongNodeName.ORDERS_SOFTWARE.toString(),"connShipping" );
        StaticBinding shippingToOrders = new StaticBinding(SockPongNodeName.SHIPPING_SOFTWARE.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(ordersToShipping, shippingToOrders);

        //--------------------------------------------------------------------------------------------------------------

        //Users---------------------------------------------------------------------------------------------------------
        // Users_Software -> Users_Db_Container
        StaticBinding usersToDb = new StaticBinding(SockPongNodeName.USERS_SOFTWARE.toString(), SockPongReqCap.CONN.toString());
        StaticBinding dbToUsers = new StaticBinding(SockPongNodeName.USERS_DB_CONTAINER.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(usersToDb, dbToUsers);
        //--------------------------------------------------------------------------------------------------------------

        //Carts---------------------------------------------------------------------------------------------------------
        // Carts_Software -> Carts_Db_Container
        StaticBinding cartsToDb = new StaticBinding(SockPongNodeName.CARTS_SOFTWARE.toString(), SockPongReqCap.CONN.toString());
        StaticBinding dbToCarts = new StaticBinding(SockPongNodeName.CARTS_DB_CONTAINER.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(cartsToDb, dbToCarts);
        //--------------------------------------------------------------------------------------------------------------

        //Shipping------------------------------------------------------------------------------------------------------
        // Shipping_Software -> RabbitMQ_Container
        StaticBinding shippingToRabbit = new StaticBinding(SockPongNodeName.SHIPPING_SOFTWARE.toString(), SockPongReqCap.CONN.toString());
        StaticBinding rabbitToShipping = new StaticBinding(SockPongNodeName.RABBITMQ_CONTAINER.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(shippingToRabbit, rabbitToShipping);
        //--------------------------------------------------------------------------------------------------------------

        //QueueMaster---------------------------------------------------------------------------------------------------
        // Queue_Master_Container -> RabbitMQ_Container
        StaticBinding queueToRabbit = new StaticBinding(SockPongNodeName.QUEUE_MASTER_CONTAINER.toString(), SockPongReqCap.CONN.toString());
        StaticBinding rabbitToQueue = new StaticBinding(SockPongNodeName.RABBITMQ_CONTAINER.toString(), SockPongReqCap.ENDP.toString());
        topologyApp.addStaticBinding(queueToRabbit, rabbitToQueue);
        //--------------------------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------------

        return topologyApp;

    }
}
