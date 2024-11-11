import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.WatchedEvent;

public class SimpleZooKeeperClient {

    public static void main(String[] args) {
        String zookeeperHost = "192.168.59.130:2181";
        int sessionTimeout = 3000; // Session timeout in milliseconds

        // Create a ZooKeeper client
        try {
            ZooKeeper zooKeeper = new ZooKeeper(zookeeperHost, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    // Handle events (for now, we just print the event type)
                    System.out.println("Event received: " + event.getType());
                }
            });

            // Check if the connection is successful
            System.out.println("Successfully connected to ZooKeeper at " + zookeeperHost);

            // Close the ZooKeeper connection
            zooKeeper.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
