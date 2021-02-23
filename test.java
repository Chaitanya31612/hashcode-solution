import java.util.*;
import java.io.*;

class PizzaIng {
    int pid;
    int numOfIng;
    List<String> Ingredients = new ArrayList<String>();

    public PizzaIng(int pid, int numOfIng, List<String> Ingredients) {
        this.pid=pid;
        this.numOfIng = numOfIng;
        this.Ingredients = Ingredients;
    }
}

class delivery {
    public int numofDelivery;
    public List<Integer> idofpizza = new ArrayList<Integer>();

    public delivery(int numofDelivery, List<Integer> idofpizza) {
        this.numofDelivery=numofDelivery;
        this.idofpizza=idofpizza;
    }
}

public class test{
    public static void main(String args[]) throws IOException {
        //System.setIn(new FileInputStream(new File("a_example")));
        System.setIn(new FileInputStream(new File("b_little_bit_of_everything.in")));
        //System.setIn(new FileInputStream(new File("c_many_ingredients.in")));
        //System.setIn(new FileInputStream(new File("d_many_pizzas.in")));
        //System.setIn(new FileInputStream(new File("e_many_teams.in")));

        //System.setOut(new PrintStream(new File("output_b_new.txt")));

        Scanner s = new Scanner(System.in);
        int m=s.nextInt();
        int t2=s.nextInt();
        int t3=s.nextInt();
        int t4=s.nextInt();
        //System.out.println(t2+" "+t3+" "+t4);
        
        List<PizzaIng> PizzaIngs = new ArrayList<PizzaIng>();

        for(int i=0;i<m;i++){
            int numpizza=s.nextInt();
            List<String> ingpizza = new ArrayList<String>();
            for(int j=0;j<numpizza;j++){
                ingpizza.add(s.next());
            }
            PizzaIng pza = new PizzaIng(i, numpizza, ingpizza);
            PizzaIngs.add(pza);

            //System.out.println(pza.numOfIng+" "+pza.getIngredients());
            
        }

        Collections.sort(PizzaIngs, new Comparator<PizzaIng>(){
            public int compare(PizzaIng p1, PizzaIng p2) {
                return p2.numOfIng - p1.numOfIng;
            }
        });
        
        int premain = m, numofDel = 0; 
        List<delivery> deliveries = new ArrayList<delivery>();
        while(premain>0) {
            //System.out.println(premain);
            List<Integer> pizzaindx = new ArrayList<>();
            if (t4 != 0 && premain >= 4) {
                pizzaindx.add(PizzaIngs.get(0).pid);
                PizzaIngs.remove(0);
                pizzaindx.add(PizzaIngs.get(--premain-1).pid);
                PizzaIngs.remove(premain-1);
                pizzaindx.add(PizzaIngs.get((--premain)/3).pid);
                PizzaIngs.remove(premain/3);
                pizzaindx.add(PizzaIngs.get((2*(--premain))/3).pid);
                PizzaIngs.remove((2*premain)/3);
                deliveries.add(new delivery(4, pizzaindx));
                t4--;
                premain--;
                numofDel++;
            }
            else if (t3 != 0 && premain >= 3) {
                pizzaindx.add(PizzaIngs.get(0).pid);
                PizzaIngs.remove(0);
                pizzaindx.add(PizzaIngs.get(--premain-1).pid);
                PizzaIngs.remove(premain-1);
                pizzaindx.add(PizzaIngs.get((--premain)/2).pid);
                PizzaIngs.remove(premain/2);
                deliveries.add(new delivery(3, pizzaindx));
                t3--;
                premain--;
                numofDel++;
            }
            else if (t2 != 0 && premain >= 2) {
                pizzaindx.add(PizzaIngs.get(0).pid);
                PizzaIngs.remove(0);
                pizzaindx.add(PizzaIngs.get(--premain-1).pid);
                PizzaIngs.remove(premain-1);
                deliveries.add(new delivery(2, pizzaindx));
                t2--;
                premain--;
                numofDel++;
            }
        }
        System.out.println(numofDel);
        for (delivery del : deliveries) {
            System.out.print(del.numofDelivery()); 
            for (int i = 0; i < del.numofDelivery; i++) {
                System.out.print(" " + del.idofpizza.get(i));
            }
            System.out.println("");
        }
        s.close();
    }
}