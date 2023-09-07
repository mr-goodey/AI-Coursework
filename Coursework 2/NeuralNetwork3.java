package coursework;

import java.io.IOException;
import java.util.Random;

public class NeuralNetwork3 {
	public static double input1, input2, input3, input4, input5, output;
	public static double error = 0;
	public static double[] weights = new double[18];
	public static double[] biases = new double[4];
	public static double[] s_and_u = new double[8];
	public static double[] deltas = new double[4];
	public static double p = 0.1;
	public static double min = -0.4;
	public static double max = 0.4;
	public NeuralNetwork3() {
		Random r = new Random();
		double ran;
		for (int i = 0; i < 18; i++) {
			ran = min + (max - min) * r.nextDouble();
			weights[i] = ran;
		}
		for (int i = 0; i < 4; i++) {
			ran = min + (max - min) * r.nextDouble();
			biases[i] = ran;
		}
	}
	public void forwardPass() {
		s_and_u[0] = (weights[0] * input1) + (weights[3] * input2) + (weights[6] * input3) + (weights[9] * input4) + (weights[12] * input5) + (biases[0]);
		s_and_u[1] = 1 / (1 + Math.exp(-1 * s_and_u[0]));
		s_and_u[2] = (weights[1] * input1) + (weights[4] * input2) + (weights[7] * input3) + (weights[10] * input4) + (weights[13] * input5) + (biases[1]);
		s_and_u[3] = 1 / (1 + Math.exp(-1 * s_and_u[2]));
		s_and_u[4] = (weights[2] * input1) + (weights[5] * input2) + (weights[8] * input3) + (weights[11] * input4) + (weights[14] * input5) + (biases[2]);
		s_and_u[5] = 1 / (1 + Math.exp(-1 * s_and_u[4]));
		s_and_u[6] = (weights[15] * s_and_u[1]) + (weights[16] * s_and_u[3]) + (weights[17] * s_and_u[5]) + (biases[3]);
		s_and_u[7] = 1 / (1 + Math.exp(-1 * s_and_u[6]));
	}
	public void backwardPass() {
		deltas[0] = (output - s_and_u[7]) * (s_and_u[7] * (1 - s_and_u[7]));
		deltas[1] = (weights[17] * deltas[0]) * (s_and_u[5] * (1 - s_and_u[5]));
		deltas[2] = (weights[16] * deltas[0]) * (s_and_u[3] * (1 - s_and_u[3]));
		deltas[3] = (weights[15] * deltas[0]) * (s_and_u[1] * (1 - s_and_u[1]));
		weights[0] = weights[0] + (p * deltas[3] * input1);
		weights[1] = weights[1] + (p * deltas[2] * input1);
		weights[2] = weights[2] + (p * deltas[1] * input1);
		weights[3] = weights[3] + (p * deltas[3] * input2);
		weights[4] = weights[4] + (p * deltas[2] * input2);
		weights[5] = weights[5] + (p * deltas[1] * input2);
		weights[6] = weights[6] + (p * deltas[3] * input3);
		weights[7] = weights[7] + (p * deltas[2] * input3);
		weights[8] = weights[8] + (p * deltas[1] * input3);
		weights[9] = weights[9] + (p * deltas[3] * input4);
		weights[10] = weights[10] + (p * deltas[2] * input4);
		weights[11] = weights[11] + (p * deltas[1] * input4);
		weights[12] = weights[12] + (p * deltas[3] * input5);
		weights[13] = weights[13] + (p * deltas[2] * input5);
		weights[14] = weights[14] + (p * deltas[1] * input5);
		weights[15] = weights[15] + (p * deltas[0] * s_and_u[1]);
		weights[16] = weights[16] + (p * deltas[0] * s_and_u[3]);
		weights[17] = weights[17] + (p * deltas[0] * s_and_u[5]);
		biases[0] = biases[0] + (p * deltas[3]);
		biases[1] = biases[1] + (p * deltas[2]);
		biases[2] = biases[2] + (p * deltas[1]);
		biases[3] = biases[3] + (p * deltas[0]);
	}
	public void train(NeuralNetwork3 n3, double[][] trnData) throws IOException {
		for (int j = 0; j < 15000; j++) {
			for (int i = 0; i < 870; i++) {
				input1 = trnData[i][0];
				input2 = trnData[i][1];
				input3 = trnData[i][2];
				input4 = trnData[i][3];
				input5 = trnData[i][4];
				output = trnData[i][5];
				n3.forwardPass();
				n3.backwardPass();
			}
		}
	}
	public double returnError(double[][] valData, NeuralNetwork3 n3, double[][] trnData) throws IOException {
		n3.train(n3, trnData);
		double e1, e2;
		for (int i = 0; i < 290; i++) {
			input1 = valData[i][0];
			input2 = valData[i][1];
			input3 = valData[i][2];
			input4 = valData[i][3];
			input5 = valData[i][4];
			output = valData[i][5];
			n3.forwardPass();
			e1 = output - s_and_u[7];
			e2 = Math.pow(e1, 2);
			error = error + e2;
		}
		error = error / 290;
		return error;
	}
}