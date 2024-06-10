package ClientServer.RemoteMethodInvocation;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            HelloImpl obj = new HelloImpl();

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.bind("Hello", obj);

            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
