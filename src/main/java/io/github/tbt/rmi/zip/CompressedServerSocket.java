package io.github.tbt.rmi.zip;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author blep
 */
public class CompressedServerSocket extends ServerSocket {
    public CompressedServerSocket(int port) throws IOException {
        super(port);
    }

    @Override
    public Socket accept() throws IOException {
        final Socket socket = new CompressedSocket();
        implAccept(socket);
        return socket;
    }
}
