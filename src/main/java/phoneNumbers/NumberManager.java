package phoneNumbers;

public class NumberManager {

    public NumberNode rootNode = new NumberNode();

    public void processNumber (String numberStr){
        rootNode.process(rootNode.toQueue(numberStr), rootNode);
    }


}
