package io.github.tbt.rmi.zip;

import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;

/**
 * @author blep
 */
public class CompressedServerSocketFactory implements RMIServerSocketFactory {
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        return new CompressedServerSocket(port);
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
