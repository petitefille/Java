public class OrdnetLenkeliste<T extends Comparable<T>> extends Lenkeliste<T>{

    @Override
    public void settInn(T element){
    	Node nyNode = new Node(element);

    	Node node = foerste;

    	if (foerste == null){
    	    foerste = nyNode;
            siste = nyNode;
    	    return;
    	}

    	T nesteElement = (T) node.data;

    	while (element.compareTo(nesteElement) >= 0 && nesteElement != null && node.neste != null){
	    node = node.neste;
	    nesteElement = (T) node.data;
    	}

	if (element.compareTo(nesteElement) >= 0){
	    nyNode.forrige = node;
	    node.neste = nyNode;
	}
  else{
	    nyNode.neste = node;

	    if (node.forrige != null){
		nyNode.forrige = node.forrige;
	    	node.forrige.neste = nyNode;
	    }else{
	   	foerste = nyNode;
	    }

	    node.forrige = nyNode;
	}
    }
}