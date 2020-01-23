public class MinStakk
{
    private Node topp;

    public void push(Pannekake ny) 
    {
        if (topp == null)
        {
            topp = newNode(ny);
        }
        else
        {
        topp = topp.leggPaa(ny);
        }
    }

    public Pannekake pop()
    {
        Pannekake toppen = topp.min;
        topp = topp.forrige;
        top.neste = null;

        return toppen;
    }

    public boolean is Empty() 
    {
        return topp == null;
    }

    private class Node
    {
        Node neste;
        Node forrige;
        Pannekaken min;
 
        Node(Pannekaken min)
        {
            this.min = min;
        }
  
        public Node leggPaa(Pannekake ny)
        {
            this.neste = new Node(ny);
            this.neste.forrige = this;
            return this.nste;
        }

    }
}
 
