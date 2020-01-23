class ListeMedStatus<T extends NavnOgPris> {
    Node foran;

    // Kan denne klassen være static? Hvorfor/hvorfor ikke?
    private class Node {
        T element;
        Node neste;
        boolean markert = false;
        Node(T element) {
            this.element = element;
        }
    }

    public void leggTil(T element) {
        Node nyNode = new Node(element);
        nyNode.neste = foran;
        foran = nyNode;
    }

    public double totalPris() {
        double sum = 0;
        Node peker = foran;
        while(peker != null) {
            sum += peker.element.hentPris();
            peker = peker.neste;
        }
        return sum;
    }

    public boolean sjekk(String varenavn) {
        // Alternativ til å bruke while-løkke som vist i totalPris()
        for(Node peker = foran; peker != null; peker = peker.neste) {
            if (!peker.markert && peker.element.hentNavn().equals(varenavn)) {
                peker.markert = true;
                return true;
            }
        }
        return false;
    }

    public ListeMedStatus<T> lagListeAvAlleUmarkerte() {
        ListeMedStatus<T> ny = new ListeMedStatus<T>();

        // Det er samme om man bruker for- eller while-løkke her
        for(Node peker = foran; peker != null; peker = peker.neste) {
            if (!peker.markert) {
                ny.leggTil(peker.element);
            }
        }
        return ny;
    }
}
