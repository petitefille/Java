import java.lang.InterruptedException;

interface Monitor
{
	public void ventHvisOrdBufferErFull() throws InterruptedException;
        public void ventHvisOrdBufferErTom() throws InterruptedException;
        
        public boolean erFull();
        public void settInnNull();
        public void settInnOrd(String ord);
        public String taOrdFraForrigeOrdBuffer();






		
}
