import java.util.ArrayList;
import java.util.Collections;

public class Main {
	// jeden gotowy raport
	public static void main(String[] args) {
		ArrayList<Request> arr = new ArrayList<>();
		ArrayList<Request> doDodania = new ArrayList<>();

		// przygotowanie danych
		for (int i = 0; i < 100; i++)
			// instanty
			arr.add(new Request(((int) (Math.random() * Poz.MAX1)),
					((int) (Math.random() * Poz.MAX2)), 0, 0));
		for (int i = 0; i < 100; i++)
			// na później
			doDodania.add(new Request(((int) (Math.random() * Poz.MAX1)),
					((int) (Math.random() * Poz.MAX2)), 0, ((int) (Math
							.random() * 2000)))); // 2000 -> czas
		Collections.sort(doDodania);

		FCFS d1 = new FCFS();
		SSTF d2 = new SSTF();
		CSCAN d3 = new CSCAN();
		SCAN d4 = new SCAN();
		d1.cpu.addAll(arr);
		d2.cpu.addAll(arr);
		d3.cpu.addAll(arr);
		d4.cpu.addAll(arr);
		int i;

		i = 0;
		while (!d1.cpu.isEmpty()) {
			if (doDodania.get(i).czas > d1.s2)
				d1.cpu.add(doDodania.get(i++));
			d1.wykonaj();
		}
		System.out.println("FCFS");
		System.out.println("suma przemieszczeń po ścieżkach: " + d1.s1);
		System.out.println("suma przemieszczeń po sektorach: " + d1.s2);

		i = 0;
		while (!d2.cpu.isEmpty()) {
			if (doDodania.get(i).czas > d2.s2)
				d2.cpu.add(doDodania.get(i++));
			d2.wykonaj();
		}
		System.out.println("SSTF");
		System.out.println("suma przemieszczeń po ścieżkach: " + d2.s1);
		System.out.println("suma przemieszczeń po sektorach: " + d2.s2);

		i = 0;
		while (!d3.cpu.isEmpty()) {
			if (doDodania.get(i).czas > d3.s2)
				d3.cpu.add(doDodania.get(i++));
			d3.wykonaj();
		}
		System.out.println("CSCAN");
		System.out.println("suma przemieszczeń po ścieżkach: " + d3.s1);
		System.out.println("suma przemieszczeń po sektorach: " + d3.s2);

		i = 0;
		while (!d4.cpu.isEmpty()) {
			if (doDodania.get(i).czas > d4.s2)
				d4.cpu.add(doDodania.get(i++));
			d4.wykonaj();
		}
		System.out.println("SCAN");
		System.out.println("suma przemieszczeń po ścieżkach: " + d4.s1);
		System.out.println("suma przemieszczeń po sektorach: " + d4.s2);
	}
}
