class Request implements Comparable<Request> {
	Poz p; // lokalizacja danych
	int priorytet; // czas pozosta�y na wykonanie

	public int compareTo(Request r) {
		return ((Integer) priorytet).compareTo(r.priorytet);
	}
}