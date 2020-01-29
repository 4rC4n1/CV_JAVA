import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Branch extends Node
{
    List<Integer> children;


    Branch(int value, List<String> childrenStr)
    {
        super(value,"V");

        this.children = new ArrayList<>(Collections.emptyList());
        if (childrenStr != null)
        {
            for (String s : childrenStr)
            {
                children.add(Integer.valueOf(s));

            }
        }
    }
    public List<Integer> getChildren()
    {
        return children;
    }
}
