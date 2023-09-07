package coursework;

import java.io.IOException;
import java.util.Random;

public class Annealing {
	public static double input1, input2, input3, input4, input5, output;
	public static double error = 0;
	public static double[] weights = new double[12];
	public static double[] biases = new double[3];
	public static double[] s_and_u = new double[6];
	public static double[] deltas = new double[3];
	public static double p = 0.1;
	public static double min = -0.4;
	public static double max = 0.4;
	public Annealing() {
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
	public double adjustLearningRate(int j) {
		// Adjust the learning rate, which begins at 0.1 and ends at 0.01
		p = 0.01 + ((0.1 - 0.01) * (1 - (1 / (1 + Math.exp(10 - ((20 * j) / 15000))))));
		return p;
	}
	public void train(Annealing a, double[][] trnData) throws IOException {
		for (int j = 0; j < 15000; j++) {
			for (int i = 0; i < 870; i++) {
				input1 = trnData[i][0];
				input2 = trnData[i][1];
				input3 = trnData[i][2];
				input4 = trnData[i][3];
				input5 = trnData[i][4];
				output = trnData[i][5];
				a.forwardPass();
				a.backwardPass();
			}
			// After each epoch adjust the learning rate
			p = a.adjustLearningRate(j + 1);
		}
	}
	public double returnError(double[][] valData, Annealing a, double[][] trnData) throws IOException {
		a.train(a, trnData);
		double e1, e2;
		for (int i = 0; i < 290; i++) {
			input1 = valData[i][0];
			input2 = valData[i][1];
			input3 = valData[i][2];
			input4 = valData[i][3];
			input5 = valData[i][4];
			output = valData[i][5];
			a.forwardPass();
			e1 = output - s_and_u[5];
			e2 = Math.pow(e1, 2);
			error = error + e2;
		}
		error = error / 290;
		return error;
	}
	public static void main(String[] args) throws IOException {
		Data d = new Data();
		double[][] trnData = d.getTrnData();
		double[][] valData = d.getValData();
		NeuralNetwork2 n2 = new NeuralNetwork2();
		double x1 = n2.returnError(valData, n2, trnData);
		System.out.println(x1);
		Annealing a = new Annealing();
		double x2 = a.returnError(valData, a, trnData);
		System.out.println(x2);
	}
}