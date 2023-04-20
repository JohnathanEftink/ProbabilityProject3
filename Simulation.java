public class Simulation {
	int sampleSize;
	RandNumberGenerator rng;
	void Simulation(int sampleSize) {
		this.sampleSize = sampleSize;
		this.rng = new RandNumberGenerator();
	}

	public double runSimulation() {
		long sum = 0;
		for (int i = 0; i < this.sampleSize; i++) {
			sum += getDistance(this.rng.getNextU(), this.rng.getNextU());
		}
		return (sum / this.sampleSize);
	}

	public void resetSimulation(int sampleSize) {
		this.sampleSize = sampleSize;
		this.rng = new RandNumberGenerator();	
	}

	private double getDistance(double y_1, double y_2) {
		return Math.sqrt(Math.pow(y_1, 2) + Math.pow(y_2, 2));
	}
}
