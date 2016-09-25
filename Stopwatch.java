package bilibili;

public class Stopwatch {
	public final long start;
	Stopwatch(){
		start=System.currentTimeMillis();
	}
	public double elapsedTime(){
		long now=System.currentTimeMillis();
		return (now-start)/1000.0;
	}

}
