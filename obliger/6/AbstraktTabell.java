
public interface AbstraktTabell<T> extends Iterable<T> 
{
    public boolean settInn(int index, T t);
	public T finn(int index);
	
}
