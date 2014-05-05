import java.util.ArrayList;

public class SCAN {
	ArrayList<Request> cpu = new ArrayList<Request>();
	Poz glowica; // pozycja g³owicy
	int s1 = 0; // suma ruchów po œcie¿kach
	int s2 = 0; // suma ruchów po sektorach
	boolean kierunek = true; // 1-inc, 0-dec

	SCAN() {
		glowica = new Poz(0, 0);
	}

	void dodaj(int sciezka, int sektor) {
		cpu.add(new Request(sciezka, sektor, 0, 0));
	}

	void wykonaj() {
		// TODO jazda g³owic¹ z powrotem
		if (glowica.sciezka > Poz.MAX1)
			kierunek = false;
		else if (glowica.sciezka < 0)
			kierunek = true;
		while (glowica.sektor >= 0 && glowica.sektor <= Poz.MAX2) {
			Request r = next();
			// jeœli jest zadanie, to wykonaj, jak nie, to nastêpny sektor
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
		// s2 += Poz.MAX2 + 1; // by³o sumowane...
		glowica.sektor = 0; // sektory od nowa
		if (kierunek) // nast œcie¿ka
			glowica.sciezka++;
		else
			glowica.sciezka--;
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