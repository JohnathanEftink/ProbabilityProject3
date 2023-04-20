import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
    public static void main(String args[]){
	File outFile = new File("simdata");
	Simulation sim;
	try {
	FileWriter writer = new FileWriter("simdata");
	sim = new Simulation(10);
	writer.write(String.valueOf(sim.runSimulation()) + '\n');
	for (int i = 0; i < 110; i++) {
		sim.resetSimulation(10);
		writer.write(String.valueOf(sim.runSimulation()) + '\n');
	}
	writer.close();
	} catch (Exception e) {
		System.out.println("Problem with larger loop: " + e);
	}
}
}
