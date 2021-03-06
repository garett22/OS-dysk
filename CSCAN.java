﻿import java.util.ArrayList;

public class CSCAN {
	ArrayList<Request> cpu = new ArrayList<Request>();
	Poz glowica; // pozycja głowicy
	int s1 = 0; // suma ruchów po ścieżkach
	int s2 = 0; // suma ruchów po sektorach

	CSCAN() {
		glowica = new Poz(0, 0);
	}

	void dodaj(int sciezka, int sektor) {
		cpu.add(new Request(sciezka, sektor, 0, 0));
	}

	void wykonaj() {
		if (glowica.sciezka >= Poz.MAX1)
			glowica.sciezka = 0;
		while (glowica.sektor < Poz.MAX2) {
			Request r = next();
			// jeśli jest zadanie, to wykonaj, jak nie, to następny sektor
			if (r != null)
				cpu.remove(r);
			// s1 += (glowica.sciezka >= r.p.sciezka) ? (glowica.sciezka -
			// r.p.sciezka)
			// : (r.p.sciezka - glowica.sciezka);
			// s2 += (glowica.sektor >= r.p.sektor) ? (glowica.sektor -
			// r.p.sektor)
			// : (r.p.sektor - glowica.sektor);
			glowica.sektor++; // nast sektor
			s2++;
		}
		// s2 += Poz.MAX2 + 1; // było sumowane...
		glowica.sektor = 0; // sektory od nowa
		glowica.sciezka++; // nast ścieżka
		s1++;
	}

	private Request next() {
		// wybierz kolejny element jesli jest w tym miejscu
		Request r = null;
		for (int i = 0; i < cpu.size(); i++)
			if (cpu.get(i).p.equals(glowica))
				r = cpu.get(i);
		return r;
	}
}