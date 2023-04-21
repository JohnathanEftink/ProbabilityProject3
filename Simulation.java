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

	public double runSimulation() {
		double sum = 0;
		for (int i = 0; i < this.sampleSize; i++) {
			sum += getDistance(getYVal(), getYVal());
		}
		return (sum / this.sampleSize);
	}

	public void resetSimulation(int sampleSize) {
		this.sampleSize = sampleSize;
	}

	private double getDistance(double y_1, double y_2) {
		return Math.sqrt(Math.pow(y_1, 2) + Math.pow(y_2, 2));
	}

	private double getYVal() {
		NormalDistribution normDist = new NormalDistribution(this.mean, this.stdDev);
		return normDist.inverseCumulativeProbability(rng.getNextU());
	}
}
