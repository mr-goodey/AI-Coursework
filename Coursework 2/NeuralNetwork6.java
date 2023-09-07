package coursework;

import java.io.IOException;
import java.util.Random;

public class NeuralNetwork6 {
	public static double input1, input2, input3, input4, input5, output;
	public static double error = 0;
	public static double[] weights = new double[36];
	public static double[] biases = new double[7];
	public static double[] s_and_u = new double[14];
	public static double[] deltas = new double[7];
	public static double p = 0.1;
	public static double min = -0.4;
	public static double max = 0.4;
	public NeuralNetwork6() {
		Random r = new Random();
		double ran;
		for (int i = 0; i < 36; i++) {
			ran = min + (max - min) * r.nextDouble();
			weights[i] = ran;
		}
		for (int i = 0; i < 7; i++) {
			ran = min + (max - min) * r.nextDouble();
			biases[i] = ran;
		}
	}
	public void forwardPass() {
		s_and_u[0] = (weights[0] * input1) + (weights[6] * input2) + (weights[12] * input3) + (weights[18] * input4) + (weights[24] * input5) + (biases[0]);
		s_and_u[1] = 1 / (1 + Math.exp(-1 * s_and_u[0]));
		s_and_u[2] = (weights[1] * input1) + (weights[7] * input2) + (weights[13] * input3) + (weights[19] * input4) + (weights[25] * input5) + (biases[1]);
		s_and_u[3] = 1 / (1 + Math.exp(-1 * s_and_u[2]));
		s_and_u[4] = (weights[2] * input1) + (weights[8] * input2) + (weights[14] * input3) + (weights[20] * input4) + (weights[26] * input5) + (biases[2]);
		s_and_u[5] = 1 / (1 + Math.exp(-1 * s_and_u[4]));
		s_and_u[6] = (weights[3] * input1) + (weights[9] * input2) + (weights[15] * input3) + (weights[21] * input4) + (weights[27] * input5) + (biases[3]);
		s_and_u[7] = 1 / (1 + Math.exp(-1 * s_and_u[6]));
		s_and_u[8] = (weights[4] * input1) + (weights[10] * input2) + (weights[16] * input3) + (weights[22] * input4) + (weights[28] * input5) + (biases[4]);
		s_and_u[9] = 1 / (1 + Math.exp(-1 * s_and_u[8]));
		s_and_u[10] = (weights[5] * input1) + (weights[11] * input2) + (weights[17] * input3) + (weights[23] * input4) + (weights[29] * input5) + (biases[5]);
		s_and_u[11] = 1 / (1 + Math.exp(-1 * s_and_u[10]));
		s_and_u[12] = (weights[30] * s_and_u[1]) + (weights[31] * s_and_u[3]) + (weights[32] * s_and_u[5]) + (weights[33] * s_and_u[7]) + (weights[34] * s_and_u[9]) + (weights[35] * s_and_u[11]) + (biases[6]);
		s_and_u[13] = 1 / (1 + Math.exp(-1 * s_and_u[12]));
	}
	public void backwardPass() {
		deltas[0] = (output - s_and_u[13]) * (s_and_u[13] * (1 - s_and_u[13]));
		deltas[1] = (weights[35] * deltas[0]) * (s_and_u[11] * (1 - s_and_u[11]));
		deltas[2] = (weights[34] * deltas[0]) * (s_and_u[9] * (1 - s_and_u[9]));
		deltas[3] = (weights[33] * deltas[0]) * (s_and_u[7] * (1 - s_and_u[7]));
		deltas[4] = (weights[32] * deltas[0]) * (s_and_u[5] * (1 - s_and_u[5]));
		deltas[5] = (weights[31] * deltas[0]) * (s_and_u[3] * (1 - s_and_u[3]));
		deltas[6] = (weights[30] * deltas[0]) * (s_and_u[1] * (1 - s_and_u[1]));
		weights[0] = weights[0] + (p * deltas[6] * input1);
		weights[1] = weights[1] + (p * deltas[5] * input1);
		weights[2] = weights[2] + (p * deltas[4] * input1);
		weights[3] = weights[3] + (p * deltas[3] * input1);
		weights[4] = weights[4] + (p * deltas[2] * input1);
		weights[5] = weights[5] + (p * deltas[1] * input1);
		weights[6] = weights[6] + (p * deltas[6] * input2);
		weights[7] = weights[7] + (p * deltas[5] * input2);
		weights[8] = weights[8] + (p * deltas[4] * input2);
		weights[9] = weights[9] + (p * deltas[3] * input2);
		weights[10] = weights[10] + (p * deltas[2] * input2);
		weights[11] = weights[11] + (p * deltas[1] * input2);
		weights[12] = weights[12] + (p * deltas[6] * input3);
		weights[13] = weights[13] + (p * deltas[5] * input3);
		weights[14] = weights[14] + (p * deltas[4] * input3);
		weights[15] = weights[15] + (p * deltas[3] * input3);
		weights[16] = weights[16] + (p * deltas[2] * input3);
		weights[17] = weights[17] + (p * deltas[1] * input3);
		weights[18] = weights[18] + (p * deltas[6] * input4);
		weights[19] = weights[19] + (p * deltas[5] * input4);
		weights[20] = weights[20] + (p * deltas[4] * input4);
		weights[21] = weights[21] + (p * deltas[3] * input4);
		weights[22] = weights[22] + (p * deltas[2] * input4);
		weights[23] = weights[23] + (p * deltas[1] * input4);
		weights[24] = weights[24] + (p * deltas[6] * input5);
		weights[25] = weights[25] + (p * deltas[5] * input5);
		weights[26] = weights[26] + (p * deltas[4] * input5);
		weights[27] = weights[27] + (p * deltas[3] * input5);
		weights[28] = weights[28] + (p * deltas[2] * input5);
		weights[29] = weights[29] + (p * deltas[1] * input5);
		weights[30] = weights[30] + (p * deltas[0] * s_and_u[1]);
		weights[31] = weights[31] + (p * deltas[0] * s_and_u[3]);
		weights[32] = weights[32] + (p * deltas[0] * s_and_u[5]);
		weights[33] = weights[33] + (p * deltas[0] * s_and_u[7]);
		weights[34] = weights[34] + (p * deltas[0] * s_and_u[9]);
		weights[35] = weights[35] + (p * deltas[0] * s_and_u[11]);
		biases[0] = biases[0] + (p * deltas[6]);
		biases[1] = biases[1] + (p * deltas[5]);
		biases[2] = biases[2] + (p * deltas[4]);
		biases[3] = biases[3] + (p * deltas[3]);
		biases[4] = biases[4] + (p * deltas[2]);
		biases[5] = biases[5] + (p * deltas[1]);
		biases[6] = biases[6] + (p * deltas[0]);
	}
	public void train(NeuralNetwork6 n6, double[][] trnData) throws IOException {
		for (int j = 0; j < 15000; j++) {
			for (int i = 0; i < 870; i++) {
				input1 = trnData[i][0];
				input2 = trnData[i][1];
				input3 = trnData[i][2];
				input4 = trnData[i][3];
				input5 = trnData[i][4];
				output = trnData[i][5];
				n6.forwardPass();
				n6.backwardPass();
			}
		}
	}
	public double returnError(double[][] valData, NeuralNetwork6 n6, double[][] trnData) throws IOException {
		n6.train(n6, trnData);
		double e1, e2;
		for (int i = 0; i < 290; i++) {
			input1 = valData[i][0];
			input2 = valData[i][1];
			input3 = valData[i][2];
			input4 = valData[i][3];
			input5 = valData[i][4];
			output = valData[i][5];
			n6.forwardPass();
			e1 = output - s_and_u[13];
			e2 = Math.pow(e1, 2);
			error = error + e2;
		}
		error = error / 290;
		return error;
	}
}