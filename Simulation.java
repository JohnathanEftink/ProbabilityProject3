import org.apache.commons.math3.distribution.NormalDistribution;

public class Simulation {
	int sampleSize;
	double mean;
	double stdDev;
	RandNumberGenerator rng;
	public Simulation(int sampleSize) {
		this.sampleSize = sampleSize;
		this.rng = new RandNumberGenerator();
		this.mean = 0.0;
		this.stdDev = 57.0;
	}

	public static void main(String[] args) {
		System.out.println(Simulation.getYVal(0.5, 0.0, 57.0));
	}

	public double runSimulation() {
		double sum = 0;
		for (int i = 0; i < this.sampleSize; i++) {
			sum += getDistance(getYVal(rng.getNextU(), this.mean, this.stdDev), getYVal(rng.getNextU(),this.mean, this.stdDev));
		}
		return (sum / this.sampleSize);
	}

	public void resetSimulation(int sampleSize) {
		this.sampleSize = sampleSize;
	}

	private double getDistance(double y_1, double y_2) {
		return Math.sqrt(Math.pow(y_1, 2) + Math.pow(y_2, 2));
	}

	public static double getYVal(double prob, double mean, double stdDev) {
		NormalDistribution normDist = new NormalDistribution(mean, stdDev);
		return normDist.inverseCumulativeProbability(prob);
	}
}
