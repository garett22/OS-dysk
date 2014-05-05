import java.util.ArrayList;

public class FCFS {
	ArrayList<Request> cpu = new ArrayList<Request>();
	Poz glowica; // pozycja głowicy
	int s1 = 0; // suma ruchów po ścieżkach
	int s2 = 0; // suma ruchów po sektorach

	FCFS() {
		glowica = new Poz(0, 0);
	}

	void dodaj(int sciezka, int sektor) {
		cpu.add(new Request(sciezka, sektor, 0, 0));
	}

	void wykonaj() {
		Request r = cpu.get(0);
		cpu.remove(0);
		s1 += (glowica.sciezka >= r.p.sciezka) ? (glowica.sciezka - r.p.sciezka)
				: (r.p.sciezka - glowica.sciezka);
		s2 += (glowica.sektor >= r.p.sektor) ? (glowica.sektor - r.p.sektor)
				: (r.p.sektor - glowica.sektor);
		glowica = r.p;
		glowica.sektor++; // odczytano blok, więc ustaw się za nim
		if (glowica.sektor >= Poz.MAX2)
			glowica.sektor = 0;
	}
	/*
	 * void wykonaj() { if (!cpu.isEmpty()) { Request r = cpu.get(0);
	 * cpu.remove(0); s1 += (glowica.sciezka >= r.p.sciezka) ? (glowica.sciezka
	 * - r.p.sciezka) : (r.p.sciezka - glowica.sciezka); s2 += (glowica.sektor
	 * >= r.p.sektor) ? (glowica.sektor - r.p.sektor) : (r.p.sektor -
	 * glowica.sektor); glowica = r.p; glowica.sektor++; // odczytano blok, więc
	 * ustaw się za nim if (glowica.sektor >= Poz.MAX2) glowica.sektor = 0; } }
	 */
}
