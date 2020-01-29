public class Leave extends Node
{
    String color;

    Leave(int value, String color)
    {
        super(value, "L");
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }
}
