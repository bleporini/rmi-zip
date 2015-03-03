package io.github.tbt.rmi.zip;

import java.rmi.Remote;

public interface MyRemoteService extends Remote{
    String sayHello() throws java.rmi.RemoteException;;
}
