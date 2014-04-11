import java.util.ArrayList;

public class SSTF {
	ArrayList<Request> cpu = new ArrayList<Request>();
	Poz glowica; // pozycja głowicy
	int s1 = 0; // suma ruchów po ścieżkach
	int s2 = 0; // suma ruchów po sektorach

	SSTF() {
		glowica.sciezka = 0;
		glowica.sektor = 0;
	}

	void dodaj(int sciezka, int sektor) {
		cpu.add(new Request(sciezka, sektor, 0, 0));
	}

	void wykonaj() {
		if (!cpu.isEmpty()) {
			Request r = next();
			cpu.remove(r);
			s1 += (glowica.sciezka >= r.p.sciezka) ? (glowica.sciezka - r.p.sciezka)
					: (r.p.sciezka - glowica.sciezka);
			s2 += (glowica.sektor >= r.p.sektor) ? (glowica.sektor - r.p.sektor)
					: (r.p.sektor - glowica.sektor);
			glowica = r.p;
			glowica.sektor++; // odczytano blok, więc ustaw się za nim
			if (glowica.sektor >= Poz.MAX2)
				glowica.sektor = 0;
		}
	}

	private Request next() { // wybierz najbliższy element
		Request r = cpu.get(0);
		for (int i = 1; i < cpu.size(); i++)
			if (cpu.get(i).p.compareTo(r.p) > 0)
				r = cpu.get(i);
		return r;
	}
}