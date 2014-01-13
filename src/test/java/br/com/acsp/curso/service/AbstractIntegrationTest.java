package br.com.acsp.curso.service;

import br.com.acsp.curso.config.PersistenceConfig;
import com.mongodb.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: chrisreichel
 * Date: 11/01/2014
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class})
public abstract class AbstractIntegrationTest {

    @Autowired
    Mongo mongo;

    @Before
    public void setUp() {

        DB database = mongo.getDB("acsp-db");

        // Customers

        DBCollection customers = database.getCollection("customer");
        customers.remove(new BasicDBObject());

        BasicDBObject address = new BasicDBObject();
        address.put("city", "New York");
        address.put("street", "Broadway");
        address.put("country", "United States");

        BasicDBList addresses = new BasicDBList();
        addresses.add(address);

        DBObject dave = new BasicDBObject("firstname", "Dave");
        dave.put("lastname", "Matthews");
        dave.put("email", "dave@dmband.com");
        dave.put("addresses", addresses);

        customers.insert(dave);

        // Products

        DBCollection products = database.getCollection("product");
        products.drop();

        DBObject iPad = new BasicDBObject("name", "iPad");
        iPad.put("description", "Apple tablet device");
        iPad.put("price", 499.0);
        iPad.put("attributes", new BasicDBObject("connector", "plug"));

        DBObject macBook = new BasicDBObject("name", "MacBook Pro");
        macBook.put("description", "Apple notebook");
        macBook.put("price", 1299.0);

        BasicDBObject dock = new BasicDBObject("name", "Dock");
        dock.put("description", "Dock for iPhone/iPad");
        dock.put("price", 49.0);
        dock.put("attributes", new BasicDBObject("connector", "plug"));

        products.insert(iPad, macBook, dock);

        // Orders

        DBCollection orders = database.getCollection("order");
        orders.drop();

        // Line items

        DBObject iPadLineItem = new BasicDBObject("product", iPad);
        iPadLineItem.put("amount", 2);

        DBObject macBookLineItem = new BasicDBObject("product", macBook);
        macBookLineItem.put("amount", 1);

        BasicDBList lineItems = new BasicDBList();
        lineItems.add(iPadLineItem);
        lineItems.add(macBookLineItem);

        DBObject order = new BasicDBObject("customer", new DBRef(database, "customer", dave.get("_id")));
        order.put("lineItems", lineItems);
        order.put("shippingAddress", address);

        orders.insert(order);
    }
}
