package coursework;

public class LINEST {
	public static double input1, input2, input3, input4, input5, output;
	public static double error = 0;
	// Use the parameters produced by the LINEST function in Excel to produce a new model
	public static double[] parameters = {-0.00625, -0.00896, 0.000724, 0.00053, 0.016058, 0.998321};
	public double model(double[][] tstData) {
		double eOut, e1, e2;
		for (int i = 0; i < 290; i++) {
			input1 = tstData[i][0];
			input2 = tstData[i][1];
			input3 = tstData[i][2];
			input4 = tstData[i][3];
			input5 = tstData[i][4];
			output = tstData[i][5];
			eOut = (input1 * parameters[5]) + (input2 * parameters[4]) + (input3 * parameters[3]) + (input4 * parameters[2]) + (input5 * parameters[1]) + (parameters[0]);
			e1 = output - eOut;
			e2 = Math.pow(e1, 2);
			error = error + e2;
		}
		error = error / 290;
		return error;
	}
}