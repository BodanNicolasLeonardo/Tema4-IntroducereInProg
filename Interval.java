
public class Interval {
	
	private double minim;
	private double maxim;
	private int nrTestate=0;
	private int nrInterval=0;
	
	public Interval(double minim, double maxim) {
		this.minim = minim;
		this.maxim = maxim;
		this.nrTestate = 0;
		this.nrInterval = 0;
	}
	
	public void verifica(double nr) {
		nrTestate++;
		if(nr>=minim && nr<=maxim)
			nrInterval++;
	}
	
	public double procent() {
		return (nrInterval / (double) nrTestate) * 100.0;
	}
	
	public String toString() {
		return "["+minim+","+maxim+"] -> "+(int)procent()+"%";
	}

	public double getMinim() {
		return minim;
	}
	
	public double getMaxim() {
		return maxim;
	}
	
}