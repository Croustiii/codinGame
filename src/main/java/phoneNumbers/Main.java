package phoneNumbers;


public class Main {

    public static void main(String[] args) {

        String test =  "0666643918";
        String test2 = "0676643918";

        NumberManager nm = new NumberManager();
        nm.processNumber(test);

        nm.processNumber(test2);


        System.out.println("done");


    }

}
