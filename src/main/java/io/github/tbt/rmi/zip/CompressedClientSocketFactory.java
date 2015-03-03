package io.github.tbt.rmi.zip;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

/**
 * @author blep
 */
public class CompressedClientSocketFactory implements RMIClientSocketFactory, Serializable {
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return new CompressedSocket(host, port);
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        return this.getClass().equals(obj.getClass());
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }
}
