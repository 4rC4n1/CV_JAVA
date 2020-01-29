import java.util.*;

class Tree implements TreeInterface
{
    List<Node> tree;

    public Tree()
    {
    this.tree = new ArrayList<>(Collections.emptyList());
    }

    @Override
    public String resolveTree()
    {
        String result = isTreeContinuous();
        if (isTreeContinuous() != "NO")
        {
            String greenLeaves = (greenLeavesCount());
            String brownLeaves = (brownLeavesCount());
            String ripeNuts = (ripeNutsCount());
            String unRipeNuts = (unRipeNutsCount());
            result = result + "\n" + greenLeaves + "\n" + brownLeaves + "\n" + ripeNuts + "\n" + unRipeNuts;
        }
        System.out.println(result);
        return result;
    }

    // Create node object of type due to input values to the node list "tree"
    @Override
    public void addNode(String nodeInput)
    {
        List<String> parameters = Arrays.asList(nodeInput.split(";"));
        
        int position = Integer.parseInt(parameters.get(0));
        String nodeType = parameters.get(1);
        switch (nodeType)
        {
            case "V":
            {
                int lastIndex = parameters.size();

                if (lastIndex > 1)
                {
                    this.tree.add(position - 1, new Branch(position, parameters.subList(2,lastIndex)));
                }
                else
                {
                    this.tree.add(position - 1, new Branch(position, null));
                }
                break;
            }
            case "L":
            {
                this.tree.add(position -1, new Leave(position, parameters.get(2)));
                break;
            }
            case "O":
            {
                this.tree.add(position-1, new Nut(position, parameters.get(2)));
                break;
            }
            default:
                System.out.println("Unknown parameter at node" + position);
        }
    }

    @Override
    public String greenLeavesCount()
    {
        int count = 0;
        for (Node node : tree)
        {
            if (node instanceof Leave)
            {
                if (((Leave) node).getColor().contains("Z"))
                {
                    count++;
                }
            }
        }
        return ("L;Z;" + count);
    }

    @Override
    public String brownLeavesCount()
    {
        int count = 0;
        for (Node node : tree)
        {
            if (node instanceof Leave)
            {
                if (((Leave) node).getColor().contains("H"))
                {
                    count++;
                }
            }
        }
        return ("L;H;" + count);
    }

    @Override
    public String ripeNutsCount()
    {
        int count = 0;
        for (Node node : tree)
    {
        if (node instanceof Nut)
        {
            if (((Nut) node).getRipe().contains("Z"))
            {
                count++;
            }
        }
    }
        return ("O;Z;" + count);
}

    @Override
    public String unRipeNutsCount()
    {
        int count = 0;
        for (Node node : tree)
        {
            if (node instanceof Nut)
            {
                if (((Nut) node).getRipe().contains("N"))
                {
                    count++;
                }
            }
        }
        return ("O;N;" + count);
    }

    @Override
    public String isTreeContinuous()

    {
        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.add(0);
        int counter = 1;
        while (nodeStack.empty() == false)
        {
            List<Integer> nodeChildren = traverse(nodeStack.pop());
            if (nodeChildren != null)
            {
                for (Integer i :nodeChildren)
                {
                    nodeStack.push(i-1);
                    counter++;
                }
            }
        }
        if (counter != tree.size())
        {
            return ("NO");
        }
        else{
        return ("YES");}


    }

    private List<Integer> traverse(int nodeTop)
    {
        if (tree.get(nodeTop) instanceof Branch)
        {
            return (((Branch) tree.get(nodeTop)).children);
        }
        return (null);
    }
}
