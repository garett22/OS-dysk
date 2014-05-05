import java.util.ArrayList;

public class Main {
	// jeden gotowy raport
	// dodaæ czasy oczekiwania na wykonanie zlecenia
	public static void main(String[] args) {
		ArrayList<Request> arr = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			arr.add(new Request(((int) (Math.random() * Poz.MAX1)),
					((int) (Math.random() * Poz.MAX2)), 0, 0));
		// System.out.println(arr.toString());
		FCFS d1 = new FCFS();
		SSTF d2 = new SSTF();
		CSCAN d3 = new CSCAN();
		SCAN d4 = new SCAN();
		d1.cpu.addAll(arr);
		d2.cpu.addAll(arr);
		d3.cpu.addAll(arr);
		d4.cpu.addAll(arr);

		while (!d1.cpu.isEmpty())
			d1.wykonaj();
		System.out.println(d1.s1 + " " + d1.s2);
		while (!d2.cpu.isEmpty())
			d2.wykonaj();
		System.out.println(d2.s1 + " " + d2.s2);
		while (!d3.cpu.isEmpty())
			d3.wykonaj();
		System.out.println(d3.s1 + " " + d3.s2);
		while (!d4.cpu.isEmpty())
			d4.wykonaj();
		System.out.println(d4.s1 + " " + d4.s2);
	}
}
