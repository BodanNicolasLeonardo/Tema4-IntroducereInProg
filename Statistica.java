import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Statistica {

	public static void main(String[] args) {
		try {
		File fisierIntervale=new File("C:\\Users\\User\\eclipse-workspace\\Tema4\\intervale.dat");
		Scanner scannerIntervale=new Scanner(fisierIntervale);
		Interval[] intervale=new Interval[3];
		int i=0;
		
		while(scannerIntervale.hasNextLine()) {
			String linie=scannerIntervale.nextLine();
			String[] imparte=linie.replace("[","").replace("]","").split(",");
			Double minim=Double.parseDouble(imparte[0]);
			Double maxim=Double.parseDouble(imparte[1]);
			
			intervale[i]=new Interval(minim,maxim);
			i++;
		}
		scannerIntervale.close();
		
		File fisierNr=new File("D:\\eclipse-workspace\\Tema 4\\numere.dat");
		Scanner scannerNr=new Scanner(fisierNr);
		double[] nrCitite=new double[100];
		int totalElemente=0;
		
		while(scannerNr.hasNextDouble()) {
			double numar=scannerNr.nextDouble();
			boolean dublura=false;
			for(int j=0;j<totalElemente;j++) {
				if(nrCitite[j]==numar) {
					dublura=true;
					break;
				}
			}
			if(dublura)
				System.out.println("Eroare: numarul "+numar+" a fost deja citit");
			else {
				nrCitite[totalElemente]=numar;
				totalElemente++;
				
				for(int j=0;j<intervale.length;j++)
					intervale[j].verifica(numar);
			}
		}
		scannerNr.close();
		
		try {
		PrintWriter write=new PrintWriter("statistica.dat");
		for(int j=0;j<intervale.length;j++)
			write.println("["+intervale[j].getMinim()+","+intervale[j].getMaxim()+"] -> "+intervale[j].procent()+"%");
		write.close();
		} catch(Exception e) {
			e.printStackTrace();
	}

}catch(Exception e) {
	e.printStackTrace();
}
}
}