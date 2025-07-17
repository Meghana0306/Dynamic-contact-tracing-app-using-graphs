import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph contactGraph = new Graph();

        // Hardcoded base graph (same as GUI)
        contactGraph.addContact("192.168.0.1", "192.168.0.2");
        contactGraph.addContact("192.168.0.2", "192.168.0.3");
        contactGraph.addContact("192.168.0.3", "192.168.0.4");
        contactGraph.addContact("192.168.0.4", "192.168.0.5");

        System.out.println("Initial Contact Network:");
        contactGraph.printGraph();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source IP: ");
        String source = scanner.nextLine();
        System.out.print("Enter target IP: ");
        String target = scanner.nextLine();

        List<String> path = contactGraph.bfs(source, target);
        if (path.isEmpty() || !path.get(path.size() - 1).equals(target)) {
            System.out.println("No path found.");
        } else {
            String log = "Malware exposure path: " + path;
            String encrypted = Encryptor.encrypt(log);
            String decrypted = Encryptor.decrypt(encrypted);

            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        }
    }
}
