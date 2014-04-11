class Request implements Comparable<Request> {
	Poz p; // lokalizacja danych
	int priorytet; // czas pozostały na wykonanie
	int czas; //kiedy ma się pojawić dany request
	
	Request(int sciezka,int sektor,int priorytet,int czas){
		p.sciezka=sciezka;
		p.sektor=sektor;
		this.priorytet=priorytet; // 0, jeśli nieistotne
		this.czas=czas;
	}
	
	public int compareTo(Request r) {
		return ((Integer) priorytet).compareTo(r.priorytet);
	}
}