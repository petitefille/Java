import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

class  Tabell<T> implements AbstraktTabell<T>
{
    private ArrayList<T> buffer;
	private int currentSize;
	
	
	 
	    public Tabell(int i)
		{
		    this.buffer = new ArrayList<T>(i);
		    this.currentSize = 0;
		}
		 
		public boolean settInn(int index, T t)
		{
		    growBufferIfNecessary();
			if (index <= this.buffer.size())
			{
			    this.buffer.add(index, t);
		        currentSize++;	
				return true;
			}
			
			else
			{
				return false;
			}
		}
		
		
		public Iterator<T> iterator()
		{
			return this.buffer.iterator();
		}
		
		
		public T finn(int index)
		{
			T t = this.buffer.get(index);
			return t;
		}
		
		
		 
		public void growBufferIfNecessary()
		{
		    if (currentSize == this.buffer.size())
			{
			     ArrayList<T> newBuffer = new ArrayList<T>(2*this.buffer.size());
			     for (int i = 0; i < this.buffer.size(); i++)
				 {
				     T t = this.buffer.get(i);
					 newBuffer.add(i,t);
				 }
				 
				 this.buffer = newBuffer;
		
            }	 
		}
}		 
