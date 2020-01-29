import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest

{
    @Test
    public void plusTest() {
        TreeInterface tree =  new Tree();
        tree.addNode("1;V;2;3;4");
        tree.addNode("2;L;Z");
        tree.addNode("3;O;N");
        tree.addNode("4;V;5");
        tree.addNode("5;L;Z");
        tree.addNode("6;L;H");
        String result = tree.resolveTree();
        assertEquals("NO", result);


    }
    @Test
    public void plusTest2() {
        TreeInterface tree =  new Tree();
        tree.addNode("1;V;2;3;4");
        tree.addNode("2;L;Z");
        tree.addNode("3;O;N");
        tree.addNode("4;V;5;6");
        tree.addNode("5;L;Z");
        tree.addNode("6;L;H");
        String result = tree.resolveTree();
        assertEquals("YES\nL;Z;2\nL;H;1\nO;Z;0\nO;N;1", result);}


@Test
    public void fileInputTest(){
    Main main = new Main();
}


}