package coursework;

import java.io.IOException;
import java.util.Random;

public class NeuralNetwork10 {
	public static double input1, input2, input3, input4, input5, output;
	public static double error = 0;
	public static double[] weights = new double[60];
	public static double[] biases = new double[11];
	public static double[] s_and_u = new double[22];
	public static double[] deltas = new double[11];
	public static double p = 0.1;
	public static double min = -0.4;
	public static double max = 0.4;
	public NeuralNetwork10() {
		Random r = new Random();
		double ran;
		for (int i = 0; i < 60; i++) {
			ran = min + (max - min) * r.nextDouble();
			weights[i] = ran;
		}
		for (int i = 0; i < 11; i++) {
			ran = min + (max - min) * r.nextDouble();
			biases[i] = ran;
		}
	}
	public void forwardPass() {
		s_and_u[0] = (weights[0] * input1) + (weights[10] * input2) + (weights[20] * input3) + (weights[30] * input4) + (weights[40] * input5) + (biases[0]);
		s_and_u[1] = 1 / (1 + Math.exp(-1 * s_and_u[0]));
		s_and_u[2] = (weights[1] * input1) + (weights[11] * input2) + (weights[21] * input3) + (weights[31] * input4) + (weights[41] * input5) + (biases[1]);
		s_and_u[3] = 1 / (1 + Math.exp(-1 * s_and_u[2]));
		s_and_u[4] = (weights[2] * input1) + (weights[12] * input2) + (weights[22] * input3) + (weights[32] * input4) + (weights[42] * input5) + (biases[2]);
		s_and_u[5] = 1 / (1 + Math.exp(-1 * s_and_u[4]));
		s_and_u[6] = (weights[3] * input1) + (weights[13] * input2) + (weights[23] * input3) + (weights[33] * input4) + (weights[43] * input5) + (biases[3]);
		s_and_u[7] = 1 / (1 + Math.exp(-1 * s_and_u[6]));
		s_and_u[8] = (weights[4] * input1) + (weights[14] * input2) + (weights[24] * input3) + (weights[34] * input4) + (weights[44] * input5) + (biases[4]);
		s_and_u[9] = 1 / (1 + Math.exp(-1 * s_and_u[8]));
		s_and_u[10] = (weights[5] * input1) + (weights[15] * input2) + (weights[25] * input3) + (weights[35] * input4) + (weights[45] * input5) + (biases[5]);
		s_and_u[11] = 1 / (1 + Math.exp(-1 * s_and_u[10]));
		s_and_u[12] = (weights[6] * input1) + (weights[16] * input2) + (weights[26] * input3) + (weights[36] * input4) + (weights[46] * input5) + (biases[6]);
		s_and_u[13] = 1 / (1 + Math.exp(-1 * s_and_u[12]));
		s_and_u[14] = (weights[7] * input1) + (weights[17] * input2) + (weights[27] * input3) + (weights[37] * input4) + (weights[47] * input5) + (biases[7]);
		s_and_u[15] = 1 / (1 + Math.exp(-1 * s_and_u[14]));
		s_and_u[16] = (weights[8] * input1) + (weights[18] * input2) + (weights[28] * input3) + (weights[38] * input4) + (weights[48] * input5) + (biases[8]);
		s_and_u[17] = 1 / (1 + Math.exp(-1 * s_and_u[16]));
		s_and_u[18] = (weights[9] * input1) + (weights[19] * input2) + (weights[29] * input3) + (weights[39] * input4) + (weights[49] * input5) + (biases[9]);
		s_and_u[19] = 1 / (1 + Math.exp(-1 * s_and_u[18]));
		s_and_u[20] = (weights[50] * s_and_u[1]) + (weights[51] * s_and_u[3]) + (weights[52] * s_and_u[5]) + (weights[53] * s_and_u[7]) + (weights[54] * s_and_u[9]) + (weights[55] * s_and_u[11]) + (weights[56] * s_and_u[13]) + (weights[57] * s_and_u[15]) + (weights[58] * s_and_u[17]) + (weights[59] * s_and_u[19]) + (biases[10]);
		s_and_u[21] = 1 / (1 + Math.exp(-1 * s_and_u[20]));
	}
	public void backwardPass() {
		deltas[0] = (output - s_and_u[21]) * (s_and_u[21] * (1 - s_and_u[21]));
		deltas[1] = (weights[59] * deltas[0]) * (s_and_u[19] * (1 - s_and_u[19]));
		deltas[2] = (weights[58] * deltas[0]) * (s_and_u[17] * (1 - s_and_u[17]));
		deltas[3] = (weights[57] * deltas[0]) * (s_and_u[15] * (1 - s_and_u[15]));
		deltas[4] = (weights[56] * deltas[0]) * (s_and_u[13] * (1 - s_and_u[13]));
		deltas[5] = (weights[55] * deltas[0]) * (s_and_u[11] * (1 - s_and_u[11]));
		deltas[6] = (weights[54] * deltas[0]) * (s_and_u[9] * (1 - s_and_u[9]));
		deltas[7] = (weights[53] * deltas[0]) * (s_and_u[7] * (1 - s_and_u[7]));
		deltas[8] = (weights[52] * deltas[0]) * (s_and_u[5] * (1 - s_and_u[5]));
		deltas[9] = (weights[51] * deltas[0]) * (s_and_u[3] * (1 - s_and_u[3]));
		deltas[10] = (weights[50] * deltas[0]) * (s_and_u[1] * (1 - s_and_u[1]));
		weights[0] = weights[0] + (p * deltas[10] * input1);
		weights[1] = weights[1] + (p * deltas[9] * input1);
		weights[2] = weights[2] + (p * deltas[8] * input1);
		weights[3] = weights[3] + (p * deltas[7] * input1);
		weights[4] = weights[4] + (p * deltas[6] * input1);
		weights[5] = weights[5] + (p * deltas[5] * input1);
		weights[6] = weights[6] + (p * deltas[4] * input1);
		weights[7] = weights[7] + (p * deltas[3] * input1);
		weights[8] = weights[8] + (p * deltas[2] * input1);
		weights[9] = weights[9] + (p * deltas[1] * input1);
		weights[10] = weights[10] + (p * deltas[10] * input2);
		weights[11] = weights[11] + (p * deltas[9] * input2);
		weights[12] = weights[12] + (p * deltas[8] * input2);
		weights[13] = weights[13] + (p * deltas[7] * input2);
		weights[14] = weights[14] + (p * deltas[6] * input2);
		weights[15] = weights[15] + (p * deltas[5] * input2);
		weights[16] = weights[16] + (p * deltas[4] * input2);
		weights[17] = weights[17] + (p * deltas[3] * input2);
		weights[18] = weights[18] + (p * deltas[2] * input2);
		weights[19] = weights[19] + (p * deltas[1] * input2);
		weights[20] = weights[20] + (p * deltas[10] * input3);
		weights[21] = weights[21] + (p * deltas[9] * input3);
		weights[22] = weights[22] + (p * deltas[8] * input3);
		weights[23] = weights[23] + (p * deltas[7] * input3);
		weights[24] = weights[24] + (p * deltas[6] * input3);
		weights[25] = weights[25] + (p * deltas[5] * input3);
		weights[26] = weights[26] + (p * deltas[4] * input3);
		weights[27] = weights[27] + (p * deltas[3] * input3);
		weights[28] = weights[28] + (p * deltas[2] * input3);
		weights[29] = weights[29] + (p * deltas[1] * input3);
		weights[30] = weights[30] + (p * deltas[10] * input4);
		weights[31] = weights[31] + (p * deltas[9] * input4);
		weights[32] = weights[32] + (p * deltas[8] * input4);
		weights[33] = weights[33] + (p * deltas[7] * input4);
		weights[34] = weights[34] + (p * deltas[6] * input4);
		weights[35] = weights[35] + (p * deltas[5] * input4);
		weights[36] = weights[36] + (p * deltas[4] * input4);
		weights[37] = weights[37] + (p * deltas[3] * input4);
		weights[38] = weights[38] + (p * deltas[2] * input4);
		weights[39] = weights[39] + (p * deltas[1] * input4);
		weights[40] = weights[40] + (p * deltas[10] * input5);
		weights[41] = weights[41] + (p * deltas[9] * input5);
		weights[42] = weights[42] + (p * deltas[8] * input5);
		weights[43] = weights[43] + (p * deltas[7] * input5);
		weights[44] = weights[44] + (p * deltas[6] * input5);
		weights[45] = weights[45] + (p * deltas[5] * input5);
		weights[46] = weights[46] + (p * deltas[4] * input5);
		weights[47] = weights[47] + (p * deltas[3] * input5);
		weights[48] = weights[48] + (p * deltas[2] * input5);
		weights[49] = weights[49] + (p * deltas[1] * input5);
		weights[50] = weights[50] + (p * deltas[0] * s_and_u[1]);
		weights[51] = weights[51] + (p * deltas[0] * s_and_u[3]);
		weights[52] = weights[52] + (p * deltas[0] * s_and_u[5]);
		weights[53] = weights[53] + (p * deltas[0] * s_and_u[7]);
		weights[54] = weights[54] + (p * deltas[0] * s_and_u[9]);
		weights[55] = weights[55] + (p * deltas[0] * s_and_u[11]);
		weights[56] = weights[56] + (p * deltas[0] * s_and_u[13]);
		weights[57] = weights[57] + (p * deltas[0] * s_and_u[15]);
		weights[58] = weights[58] + (p * deltas[0] * s_and_u[17]);
		weights[59] = weights[59] + (p * deltas[0] * s_and_u[19]);
		biases[0] = biases[0] + (p * deltas[10]);
		biases[1] = biases[1] + (p * deltas[9]);
		biases[2] = biases[2] + (p * deltas[8]);
		biases[3] = biases[3] + (p * deltas[7]);
		biases[4] = biases[4] + (p * deltas[6]);
		biases[5] = biases[5] + (p * deltas[5]);
		biases[6] = biases[6] + (p * deltas[4]);
		biases[7] = biases[7] + (p * deltas[3]);
		biases[8] = biases[8] + (p * deltas[2]);
		biases[9] = biases[9] + (p * deltas[1]);
		biases[10] = biases[10] + (p * deltas[0]);
	}
	public void train(NeuralNetwork10 n10, double[][] trnData) throws IOException {
		for (int j = 0; j < 15000; j++) {
			for (int i = 0; i < 870; i++) {
				input1 = trnData[i][0];
				input2 = trnData[i][1];
				input3 = trnData[i][2];
				input4 = trnData[i][3];
				input5 = trnData[i][4];
				output = trnData[i][5];
				n10.forwardPass();
				n10.backwardPass();
			}
		}
	}
	public double returnError(double[][] valData, NeuralNetwork10 n10, double[][] trnData) throws IOException {
		n10.train(n10, trnData);
		double e1, e2;
		for (int i = 0; i < 290; i++) {
			input1 = valData[i][0];
			input2 = valData[i][1];
			input3 = valData[i][2];
			input4 = valData[i][3];
			input5 = valData[i][4];
			output = valData[i][5];
			n10.forwardPass();
			e1 = output - s_and_u[21];
			e2 = Math.pow(e1, 2);
			error = error + e2;
		}
		error = error / 290;
		return error;
	}
}