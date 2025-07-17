import java.util.*;

public class IoTSimulator {
    private Graph graph;
    private Timer timer;
    private Random random = new Random();
    private Set<String> infected = new HashSet<>();
    private String[] nodes;

    public IoTSimulator(Graph graph) {
        this.graph = graph;

        // Auto-generate 100 IPs: 192.168.0.1 to 192.168.0.100
        nodes = new String[100];
        for (int i = 0; i < 100; i++) {
            nodes[i] = "192.168.0." + (i + 1);
        }

        infected.add(nodes[0]); // Start infection at 192.168.0.1
    }

    public void startSimulation() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (infected.size() >= nodes.length) return;

                String[] infectedArray = infected.toArray(new String[0]);
                String from = infectedArray[random.nextInt(infectedArray.length)];
                String to;
                int attempts = 0;

                 do {
                        to = nodes[random.nextInt(nodes.length)];
                        attempts++;
                        if (attempts > 50) return; // avoid infinite loop
                    } while (infected.contains(to) || from.equals(to));
                    

                graph.addContact(from, to);
                infected.add(to);
                System.out.println("Simulated malware spread: " + from + " -> " + to);
                //System.out.println("Infected size: " + infected.size() + " / " + nodes.length);
            }
        }, 0, 5000);
    }

    public void stopSimulation() {
        if (timer != null) timer.cancel();
    }
}
                