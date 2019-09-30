public class Main {

    public static void main (String[] Args){
        DoubleLinkedListofInterger L1 = new DoubleLinkedListofInterger();

        L1.add(8);
        L1.add(8);
        L1.add(5);
        L1.add(9);

        L1.reverse();
        L1.unique();


            System.out.println(L1.toString());
        }
    }

