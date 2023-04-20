public class Main {
    public static void main(String args[]){
	
	Simulation sim;
	sim = new Simulation(10);
	System.out.println(sim.runSimulation());
	for (int i = 0; i < 110; i++) {
		sim.resetSimulation(10);
		System.out.println(sim.runSimulation());
	}

    }
}
