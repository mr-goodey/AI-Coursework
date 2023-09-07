package coursework;

import java.io.IOException;
import java.util.Random;

public class Momentum {
	public static double input1, input2, input3, input4, input5, output;
	public static double error = 0;
	public static double[] weights = new double[12];
	public static double[] oldWeights = new double[12]; // Represents the previous weight values
	public static double[] biases = new double[3];
	public static double[] oldBiases = new double[3]; // Represents the previous bias values
	public static double[] s_and_u = new double[6];
	public static double[] deltas = new double[3];
	public static double p = 0.1;
	public static double alpha = 0.9; // Represents the alpha value
	public static double min = -0.4;
	public static double max = 0.4;
	public Momentum() {
		// Assigns oldWeights and oldBiases the same random values as weights and biases
		Random r = new Random();
		double ran;
		for (int i = 0; i < 12; i++) {
			ran = min + (max - min) * r.nextDouble();
			weights[i] = ran;
			oldWeights[i] = ran;
		}
		for (int i = 0; i < 3; i++) {
			ran = min + (max - min) * r.nextDouble();
			biases[i] = ran;
			oldBiases[i] = ran;
		}
	}
	public void forwardPass() {
		s_and_u[0] = (weights[0] * input1) + (weights[2] * input2) + (weights[4] * input3) + (weights[6] * input4) + (weights[8] * input5) + (biases[0]);
		s_and_u[1] = 1 / (1 + Math.exp(-1 * s_and_u[0]));
		s_and_u[2] = (weights[1] * input1) + (weights[3] * input2) + (weights[5] * input3) + (weights[7] * input4) + (weights[9] * input5) + (biases[1]);
		s_and_u[3] = 1 / (1 + Math.exp(-1 * s_and_u[2]));
		s_and_u[4] = (weights[10] * s_and_u[1]) + (weights[11] * s_and_u[3]) + (biases[2]);
		s_and_u[5] = 1 / (1 + Math.exp(-1 * s_and_u[4]));
	}
	public void backwardPass() {
		deltas[0] = (output - s_and_u[5]) * (s_and_u[5] * (1 - s_and_u[5]));
		deltas[1] = (weights[11] * deltas[0]) * (s_and_u[3] * (1 - s_and_u[3]));
		deltas[2] = (weights[10] * deltas[0]) * (s_and_u[1] * (1 - s_and_u[1]));
		oldWeights[0] = weights[0]; // Assign oldWeights current value of weights
		weights[0] = weights[0] + (p * deltas[2] * input1);
		weights[0] = weights[0] + (alpha * (weights[0] - oldWeights[0])); // Add alpha multiplied by the difference
		oldWeights[1] = weights[1];
		weights[1] = weights[1] + (p * deltas[1] * input1);
		weights[1] = weights[1] + (alpha * (weights[1] - oldWeights[1]));
		oldWeights[2] = weights[2];
		weights[2] = weights[2] + (p * deltas[2] * input2);
		weights[2] = weights[2] + (alpha * (weights[2] - oldWeights[2]));
		oldWeights[3] = weights[3];
		weights[3] = weights[3] + (p * deltas[1] * input2);
		weights[3] = weights[3] + (alpha * (weights[3] - oldWeights[3]));
		oldWeights[4] = weights[4];
		weights[4] = weights[4] + (p * deltas[2] * input3);
		weights[4] = weights[4] + (alpha * (weights[4] - oldWeights[4]));
		oldWeights[5] = weights[5];
		weights[5] = weights[5] + (p * deltas[1] * input3);
		weights[5] = weights[5] + (alpha * (weights[5] - oldWeights[5]));
		oldWeights[6] = weights[6];
		weights[6] = weights[6] + (p * deltas[2] * input4);
		weights[6] = weights[6] + (alpha * (weights[6] - oldWeights[6]));
		oldWeights[7] = weights[7];
		weights[7] = weights[7] + (p * deltas[1] * input4);
		weights[7] = weights[7] + (alpha * (weights[7] - oldWeights[7]));
		oldWeights[8] = weights[8];
		weights[8] = weights[8] + (p * deltas[2] * input5);
		weights[8] = weights[8] + (alpha * (weights[8] - oldWeights[8]));
		oldWeights[9] = weights[9];
		weights[9] = weights[9] + (p * deltas[1] * input5);
		weights[9] = weights[9] + (alpha * (weights[9] - oldWeights[9]));
		oldWeights[10] = weights[10];
		weights[10] = weights[10] + (p * deltas[0] * s_and_u[1]);
		weights[10] = weights[10] + (alpha * (weights[10] - oldWeights[10]));
		oldWeights[11] = weights[11];
		weights[11] = weights[11] + (p * deltas[0] * s_and_u[3]);
		weights[11] = weights[11] + (alpha * (weights[11] - oldWeights[11]));
		oldBiases[0] = biases[0];
		biases[0] = biases[0] + (p * deltas[2]);
		biases[0] = biases[0] + (alpha * (biases[0] - oldBiases[0]));
		oldBiases[1] = biases[1];
		biases[1] = biases[1] + (p * deltas[1]);
		biases[1] = biases[1] + (alpha * (biases[1] - oldBiases[1]));
		oldBiases[2] = biases[2];
		biases[2] = biases[2] + (p * deltas[0]);
		biases[2] = biases[2] + (alpha * (biases[2] - oldBiases[2]));
	}
	public void train(Momentum m, double[][] trnData) throws IOException {
		for (int j = 0; j < 15000; j++) {
			for (int i = 0; i < 870; i++) {
				input1 = trnData[i][0];
				input2 = trnData[i][1];
				input3 = trnData[i][2];
				input4 = trnData[i][3];
				input5 = trnData[i][4];
				output = trnData[i][5];
				m.forwardPass();
				m.backwardPass();
			}
		}
	}
	public double returnError(double[][] valData, Momentum m, double[][] trnData) throws IOException {
		m.train(m, trnData);
		double e1, e2;
		for (int i = 0; i < 290; i++) {
			input1 = valData[i][0];
			input2 = valData[i][1];
			input3 = valData[i][2];
			input4 = valData[i][3];
			input5 = valData[i][4];
			output = valData[i][5];
			m.forwardPass();
			e1 = output - s_and_u[5];
			e2 = Math.pow(e1, 2);
			error = error + e2;
		}
		error = error / 290;
		return error;
	}
	public static void main(String[] args) throws IOException {
		// Compare a model using momentum against an equivalent model not using momentum
		Data d = new Data();
		double[][] trnData = d.getTrnData();
		double[][] valData = d.getValData();
		NeuralNetwork2 n2 = new NeuralNetwork2();
		double x1 = n2.returnError(valData, n2, trnData);
		System.out.println(x1);
		Momentum m = new Momentum();
		double x2 = m.returnError(valData, m, trnData);
		System.out.println(x2);
	}
}