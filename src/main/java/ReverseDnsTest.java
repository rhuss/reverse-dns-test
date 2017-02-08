import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class ReverseDnsTest {

    public static void main(String[] args) throws UnknownHostException, InterruptedException {

        String version = System.getProperty("java.version");
        System.out.println("Running with Java " + version);


        int count = 0;
        while (true) {
            for (int i = 1; i <= 20; i++) {
                InetAddress address = InetAddress.getByName(getIp(args));
                Long start = System.currentTimeMillis();
                String name = address.getHostName();
                Long end = System.currentTimeMillis();
                System.out.println(String.format("[%2d/%2d] : %s == %d ms", count, i, name, end - start));
            }
            System.out.println("Sleeping for 2s ....");
            Thread.sleep(2000);
        }
    }

    private static String getIp(String[] args) {
        if (args.length > 0) {
            return args[0];
        }
        for (String env : new String[] { "DNS_CHECK_IP", "KUBERNETES_SERVICE_HOST"})
        if (System.getenv(env) != null) {
            return System.getenv(env);
        }
        throw new IllegalArgumentException("No ip address found. Set as argument or with DNS_CHECK_IP");
    }
}