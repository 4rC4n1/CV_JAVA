import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileInput
{
    public void fileInput()
        {
        TreeInterface tree =  new Tree();
        System.out.println("Reading input file");

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("inputData.txt");

        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        try
        {
           for (String line; (line = reader.readLine()) != null; )
           {
               System.out.println(line);
               tree.addNode(line);
           }
        }
        catch (Exception e){
           System.out.println("Exception: " + e.toString());

        }
        String result = tree.resolveTree();
        System.out.println(result);
    }
}
