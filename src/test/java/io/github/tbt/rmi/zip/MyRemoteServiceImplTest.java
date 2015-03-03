package io.github.tbt.rmi.zip;

import org.junit.Before;
import org.junit.Test;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteServiceImplTest {

    private static final String SERVICE_NAME = "myService";

    @Before
    public void setUp() throws Exception {
        final MyRemoteServiceImpl myRemoteService = new MyRemoteServiceImpl();
        final Remote remote = UnicastRemoteObject.exportObject(myRemoteService, 0, new CompressedClientSocketFactory(),
                new CompressedServerSocketFactory());

        LocateRegistry.createRegistry(2002);
        Registry registry = LocateRegistry.getRegistry(2002);
        registry.rebind(SERVICE_NAME, remote);
    }

    @Test
    public void testRemote() throws Exception {
        Registry registry = LocateRegistry.getRegistry(2002);
        final MyRemoteService lookup = (MyRemoteService) registry.lookup(SERVICE_NAME);
        System.out.println("lookup = " + lookup.sayHello());

    }
}