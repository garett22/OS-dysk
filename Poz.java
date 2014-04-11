class Poz implements Comparable<Poz> {
	// Pozycja głowicy lub lokalizacja danych
	// można zaniechać talerz
	int sciezka; // 0..39
	int sektor; // 0..1023
	static int MAX1 = 40;
	static int MAX2 = 1024;

	// dysk n*640MB jeśli blok ma 16kB

	Poz(int sciezka, int sektor) {
		this.sciezka = sciezka;
		this.sektor = sektor;
	}

	public int compareTo(Poz p) {
		if (sciezka != p.sciezka)
			return ((Integer) sciezka).compareTo(p.sciezka);
		else
			return ((Integer) sektor).compareTo(p.sektor);

	}
	
	public boolean equals(Poz p){
		return sciezka==p.sciezka&&sektor==p.sektor;
	}
}