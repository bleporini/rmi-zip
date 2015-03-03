package io.github.tbt.rmi.zip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * @author blep
 */
public class CompressedSocket extends Socket {

    private InputStream is = null;

    private OutputStream os = null;


    public CompressedSocket(String address, int port) throws IOException {
        super(address, port);
    }

    public CompressedSocket() {
        super();
    }

    @Override
    public synchronized InputStream getInputStream() throws IOException {
        if (is == null) {
            is = new InflaterInputStream(super.getInputStream());
        }
        return is;
    }

    @Override
    public synchronized OutputStream getOutputStream() throws IOException {
        if (os == null) {
            os = new DeflaterOutputStream(super.getOutputStream(),true);
        }
        return os;
    }
}
