import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException
    {
        ServerSocket socket = new ServerSocket();
        Socket incoming = socket.accept();

    }

}
