public class SquareContainer 
{
    public Square square;
  
    private void put(Square square) 
    {
        this.square = square;
    }
  
    public Square take() 
    {
        return this.square;
    }
}
