package poupazudo.util;


public class Data {

	public static final String JAN = "JAN";
	public static final String FEV = "FEV";
	public static final String MAR = "MAR";
	public static final String ABR = "ABR";
	public static final String MAI = "MAI";
	public static final String JUN = "JUN";
	public static final String JUL = "JUL";
	public static final String AGO = "AGO";
	public static final String SET = "SET";
	public static final String OUT = "OUT";
	public static final String NOV = "NOV";
	public static final String DEZ = "DEZ";
	
	public static String mesPorId(int id) {
		String meses[] = {JAN, FEV, MAR, ABR, MAI, JUN, JUL, AGO, SET, OUT, NOV, DEZ};
		
		for (int i=1; i<=12; i++)
			if (id == i) return meses[i-1];

		return null;
	}
	
	public static int getDia(String data) {
		String[] d = data.split("/");
		return Integer.parseInt(d[1]);
	}
	
	public static int getMes(String data) {
		String[] d = data.split("/");
		return Integer.parseInt(d[0]);
	}
	
	public static int getAno(String data) {
		String[] d = data.split("/");
		return Integer.parseInt(d[2]);
	}
}
