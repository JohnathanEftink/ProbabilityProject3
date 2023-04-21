import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Main {
	public static void main(String args[]){
		int samplesize = 10; //change sample size here
		String filename = "simdata" + samplesize;
		File outFile = new File(filename);

		Simulation sim;
		try {
			FileWriter writer = new FileWriter(filename);
			sim = new Simulation(samplesize);
			writer.write(String.valueOf(sim.runSimulation()) + '\n');
			for (int i = 0; i < 110; i++) {
				sim.resetSimulation(samplesize);
				writer.write(String.valueOf(sim.runSimulation()) + '\n');
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Problem with larger loop: " + e);
		}
	}
}
