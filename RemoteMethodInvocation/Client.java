package ClientServer.RemoteMethodInvocation;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1098);

            // Look up the remote object
            Hello stub = (Hello) registry.lookup("Hello");

            // Call the remote method
            String response = stub.sayHello();
            System.out.println("Response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
