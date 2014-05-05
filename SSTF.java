import java.util.ArrayList;

public class SSTF {
	ArrayList<Request> cpu = new ArrayList<Request>();
	Poz glowica; // pozycja głowicy
	int s1 = 0; // suma ruchów po ścieżkach
	int s2 = 0; // suma ruchów po sektorach

	SSTF() {
		glowica = new Poz(0, 0);
	}

	void dodaj(int sciezka, int sektor) {
		cpu.add(new Request(sciezka, sektor, 0, 0));
	}

	void wykonaj() {
		Request r = next(); // next daje następny i usuwa go
		s1 += (glowica.sciezka >= r.p.sciezka) ? (glowica.sciezka - r.p.sciezka)
				: (r.p.sciezka - glowica.sciezka);
		s2 += (glowica.sektor >= r.p.sektor) ? (glowica.sektor - r.p.sektor)
				: (r.p.sektor - glowica.sektor);
		glowica = r.p;
		glowica.sektor++; // odczytano blok, więc ustaw się za nim
		if (glowica.sektor >= Poz.MAX2)
			glowica.sektor = 0;
	}

	private Request next() { // wybierz najbliższy element
		Request r = cpu.get(0);
		cpu.remove(0);
		for (int i = 1; i < cpu.size(); i++) {
			int r1 = 0, r2 = 0;
			if (r.p.sciezka != cpu.get(i).p.sciezka) {
				// różnica między zapisanym a głowicą
				r1 = r.p.sciezka - glowica.sciezka;
				// różnica między bieżącym a głowicą
				r2 = r.p.sciezka - glowica.sciezka;
			} else {
				r1 = r.p.sektor - glowica.sektor;
				r2 = r.p.sektor - glowica.sektor;
			}
			// zapewnienie że obie różnice są dodatnie
			if (r1 < 0)
				r1 = r1 * (-1);
			if (r2 < 0)
				r2 = r2 * (-1);
			// sprawdzanie czy bieżący jest mniejszy
			if (r1 > r2)
				r = cpu.get(i);
			cpu.remove(i);
		}
		return r;
	}
}