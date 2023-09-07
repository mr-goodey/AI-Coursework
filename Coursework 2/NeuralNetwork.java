package coursework;

import java.io.IOException;

public class NeuralNetwork {
	public static void main(String[] args) throws IOException {
		Data d = new Data();
		double[][] trnData = d.getTrnData();
		double[][] valData = d.getValData();
		double[][] tstData = d.getTstData();
		double min;
		int best;
		double e;
		// Construct each network between 2 and 10 hidden nodes
		// Train the networks on the training set
		// Calculate the mean squared error on the validation set
		// Compare those errors and determine the best one
		// Calculate the mean squared error on the testing set
		NeuralNetwork2 n2 = new NeuralNetwork2();
		min = n2.returnError(valData, n2, trnData);
		best = 2;
		System.out.println(min);
		NeuralNetwork3 n3 = new NeuralNetwork3();
		e = n3.returnError(valData, n3, trnData);
		if (e < min) {
			min = e;
			best = 3;
		}
		System.out.println(e);
		NeuralNetwork4 n4 = new NeuralNetwork4();
		e = n4.returnError(valData, n4, trnData);
		if (e < min) {
			min = e;
			best = 4;
		}
		System.out.println(e);
		NeuralNetwork5 n5 = new NeuralNetwork5();
		e = n5.returnError(valData, n5, trnData);
		if (e < min) {
			min = e;
			best = 5;
		}
		System.out.println(e);
		NeuralNetwork6 n6 = new NeuralNetwork6();
		e = n6.returnError(valData, n6, trnData);
		if (e < min) {
			min = e;
			best = 6;
		}
		System.out.println(e);
		NeuralNetwork7 n7 = new NeuralNetwork7();
		e = n7.returnError(valData, n7, trnData);
		if (e < min) {
			min = e;
			best = 7;
		}
		System.out.println(e);
		NeuralNetwork8 n8 = new NeuralNetwork8();
		e = n8.returnError(valData, n8, trnData);
		if (e < min) {
			min = e;
			best = 8;
		}
		System.out.println(e);
		NeuralNetwork9 n9 = new NeuralNetwork9();
		e = n9.returnError(valData, n9, trnData);
		if (e < min) {
			min = e;
			best = 9;
		}
		System.out.println(e);
		NeuralNetwork10 n10 = new NeuralNetwork10();
		e = n10.returnError(valData, n10, trnData);
		if (e < min) {
			min = e;
			best = 10;
		}
		System.out.println(e);
		System.out.println(best);
		// Use the LINEST model to compare with the best model
		LINEST l = new LINEST();
		System.out.println(l.model(tstData));
		if (best == 2) {
			System.out.println(n2.returnError(tstData, n2, trnData));
		} else if (best == 3) {
			System.out.println(n3.returnError(tstData, n3, trnData));
		} else if (best == 4) {
			System.out.println(n4.returnError(tstData, n4, trnData));
		} else if (best == 5) {
			System.out.println(n5.returnError(tstData, n5, trnData));
		} else if (best == 6) {
			System.out.println(n6.returnError(tstData, n6, trnData));
		} else if (best == 7) {
			System.out.println(n7.returnError(tstData, n7, trnData));
		} else if (best == 8) {
			System.out.println(n8.returnError(tstData, n8, trnData));
		} else if (best == 9) {
			System.out.println(n9.returnError(tstData, n9, trnData));
		} else {
			System.out.println(n10.returnError(tstData, n10, trnData));
		}
	}
}