package poupazudo.util;

public class Data {

	public static final String JAN = "JANEIRO";
	public static final String FEV = "FEVEREIRO";
	public static final String MAR = "MARÇO";
	public static final String ABR = "ABRIL";
	public static final String MAI = "MAIO";
	public static final String JUN = "JUNHO";
	public static final String JUL = "JULHO";
	public static final String AGO = "AGOSTO";
	public static final String SET = "SETEMBRO";
	public static final String OUT = "OUTUBRO";
	public static final String NOV = "NOVEMBRO";
	public static final String DEZ = "DEZEMBRO";
	
	public static String mesPorId(int id) {
		String meses[] = {JAN, FEV, MAR, ABR, MAI, JUN, JUL, AGO, SET, OUT, NOV, DEZ};
		
		for (int i=1; i<=12; i++)
			if (id == i) return meses[i-1];

		return null;
	}
}
