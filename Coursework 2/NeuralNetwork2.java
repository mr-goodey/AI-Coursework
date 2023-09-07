package coursework;

import java.io.IOException;
import java.util.Random;

public class NeuralNetwork2 {
	public static double input1, input2, input3, input4, input5, output; // These represent T, W, SR, DSP, DRH, and PanE respectively
	public static double error = 0; // Represents the mean squared error
	public static double[] weights = new double[12]; // Represents weights between nodes
	public static double[] biases = new double[3]; // Represents the bias on each node
	public static double[] s_and_u = new double[6]; // Represents the weighted sums and sigmoid function applied to each node
	public static double[] deltas = new double[3]; // Represents the delta value on each node
	public static double p = 0.1; // Represents the learning rate
	public static double min = -0.4; // The minimum value a weight/bias can be randomly assigned
	public static double max = 0.4; // The maximum value a weight/bias can be randomly assigned
	public NeuralNetwork2() {
		// Randomly assign values to the weights and biases upon creation
		Random r = new Random();
		double ran;
		for (int i = 0; i < 12; i++) {
			ran = min + (max - min) * r.nextDouble();
			weights[i] = ran;
		}
		for (int i = 0; i < 3; i++) {
			ran = min + (max - min) * r.nextDouble();
			biases[i] = ran;
		}
	}
	public void forwardPass() {
		// Calculates the weighted sum on each node and applies the sigmoid function to each
		// Part of the backpropagation algorithm
		s_and_u[0] = (weights[0] * input1) + (weights[2] * input2) + (weights[4] * input3) + (weights[6] * input4) + (weights[8] * input5) + (biases[0]);
		s_and_u[1] = 1 / (1 + Math.exp(-1 * s_and_u[0]));
		s_and_u[2] = (weights[1] * input1) + (weights[3] * input2) + (weights[5] * input3) + (weights[7] * input4) + (weights[9] * input5) + (biases[1]);
		s_and_u[3] = 1 / (1 + Math.exp(-1 * s_and_u[2]));
		s_and_u[4] = (weights[10] * s_and_u[1]) + (weights[11] * s_and_u[3]) + (biases[2]);
		s_and_u[5] = 1 / (1 + Math.exp(-1 * s_and_u[4]));
	}
	public void backwardPass() {
		// Calculates delta values and then adjusts the weights and biases accordingly
		// Part of the backpropagation algorithm
		deltas[0] = (output - s_and_u[5]) * (s_and_u[5] * (1 - s_and_u[5]));
		deltas[1] = (weights[11] * deltas[0]) * (s_and_u[3] * (1 - s_and_u[3]));
		deltas[2] = (weights[10] * deltas[0]) * (s_and_u[1] * (1 - s_and_u[1]));
		weights[0] = weights[0] + (p * deltas[2] * input1);
		weights[1] = weights[1] + (p * deltas[1] * input1);
		weights[2] = weights[2] + (p * deltas[2] * input2);
		weights[3] = weights[3] + (p * deltas[1] * input2);
		weights[4] = weights[4] + (p * deltas[2] * input3);
		weights[5] = weights[5] + (p * deltas[1] * input3);
		weights[6] = weights[6] + (p * deltas[2] * input4);
		weights[7] = weights[7] + (p * deltas[1] * input4);
		weights[8] = weights[8] + (p * deltas[2] * input5);
		weights[9] = weights[9] + (p * deltas[1] * input5);
		weights[10] = weights[10] + (p * deltas[0] * s_and_u[1]);
		weights[11] = weights[11] + (p * deltas[0] * s_and_u[3]);
		biases[0] = biases[0] + (p * deltas[2]);
		biases[1] = biases[1] + (p * deltas[1]);
		biases[2] = biases[2] + (p * deltas[0]);
	}
	public void train(NeuralNetwork2 n2, double[][] trnData) throws IOException {
		// Adjusts the weights and biases a certain number of times, 15,000 times in this case
		for (int j = 0; j < 15000; j++) {
			for (int i = 0; i < 870; i++) {
				input1 = trnData[i][0];
				input2 = trnData[i][1];
				input3 = trnData[i][2];
				input4 = trnData[i][3];
				input5 = trnData[i][4];
				output = trnData[i][5];
				n2.forwardPass();
				n2.backwardPass();
			}
		}
	}
	public double returnError(double[][] valData, NeuralNetwork2 n2, double[][] trnData) throws IOException {
		// After training the network calculate the mean squared error on the validation set
		n2.train(n2, trnData);
		double e1, e2;
		for (int i = 0; i < 290; i++) {
			input1 = valData[i][0];
			input2 = valData[i][1];
			input3 = valData[i][2];
			input4 = valData[i][3];
			input5 = valData[i][4];
			output = valData[i][5];
			n2.forwardPass();
			e1 = output - s_and_u[5];
			e2 = Math.pow(e1, 2);
			error = error + e2;
		}
		error = error / 290;
		return error;
	}
}