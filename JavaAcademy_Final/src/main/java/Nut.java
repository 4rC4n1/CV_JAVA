public class Nut extends Node
{
    String ripe;

    Nut(int value, String ripe)
    {
        super(value, "O");
        this.ripe = ripe;
    }

    public String getRipe()
    {
        return ripe;
    }

}
