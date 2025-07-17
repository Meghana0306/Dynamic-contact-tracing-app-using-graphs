A JavaFX-based animated application that visualizes malware breach tracing across IoT nodes using Graph Data Structures, real-time simulation, 2D animated paths, and AES encryption for secure breach logging.

📌 Project Overview
This project is built to simulate and trace how malware can propagate across a network of IoT devices. The graph structure represents connected nodes (IP addresses), and users can:

Visualize the entire contact graph.

Trace the shortest malware breach path between two IPs using BFS.

See an animated 2D path display of the breach.

Secure the breach log with AES encryption and decryption.

🚀 Features
🔄 Real-time IoT simulation of device communication.

📊 Graph-based tracing using Breadth-First Search (BFS).

✨ 2D animated visualization of malware path (JavaFX).

🔒 Secure logging using AES-based encryption/decryption.

🖱️ User-friendly GUI for entering IPs, tracing, and visualization.

💻 Technologies Used
Category	Tools/Technologies
Programming Language	Java
GUI Framework	JavaFX
Encryption	AES (Javax Crypto Library)
DSA Concepts	Graph, BFS, Queue, Map, HashSet
Build Tools	.bat scripts (Windows)

🧠 How It Works
The IoTSimulator simulates random contacts between nodes.

The Graph class maintains connections using an adjacency list.

Users input Source and Target IPs.

BFS is used to find the shortest connection path.

Path is visualized with circles and connecting lines.

The full path is encrypted and decrypted using AES.

📷 Screenshots
(Make sure to upload images in a folder named images/ and refer them below)

md
Copy
Edit
![Contact Graph](images/contact_graph.png)
![Trace Animation](images/trace_animation.png)
🛠️ How to Run
Make sure you have Java and JavaFX installed and configured.

Option 1: Using .BAT File (Windows)
bat
Copy
Edit
run_gui_animated.bat
Option 2: Manually via Terminal
bash
Copy
Edit
javac --module-path "path/to/javafx/lib" --add-modules javafx.controls *.java
java --module-path "path/to/javafx/lib" --add-modules javafx.controls ContactTracingApp_Animated
📚 Folder Structure
bash
Copy
Edit
📁 src/
   ├── ContactTracingApp_Animated.java
   ├── Graph.java
   ├── Encryptor.java
   ├── IoTSimulator.java
   └── run_gui_animated.bat
📖 Learnings & Concepts
JavaFX UI Design

Graph theory & BFS

AES Encryption (Java Crypto)

Real-time simulation modeling

Structuring scalable Java applications

🙌 Acknowledgements
Special thanks to our mentors and institutions guiding this project, and the open-source community for the libraries and documentation.

