import java.util.* ;
import java.io.* ;

class PizzaIng {
    
    int numOfIng;
    List<String> Ingredients = new ArrayList<String>();

    public int getNumOfIng() {
        return this.numOfIng;
    }

    public void setNumOfIng(int numOfIng) {
        this.numOfIng = numOfIng;
    }

    public List<String> getIngredients() {
        return this.Ingredients;
    }

    public void setIngredients(List<String> Ingredients) {
        this.Ingredients = Ingredients;
    }

    public PizzaIng(int numOfIng, List<String> Ingredients) {
        this.numOfIng = numOfIng;
        this.Ingredients = Ingredients;
    }

}

class delivery {
    public int numofDelivery;
    public List<Integer> idofpizza = new ArrayList<Integer>();

    public int getNumofDelivery() {
        return this.numofDelivery;
    }

    public void setNumofDelivery(int numofDelivery) {
        this.numofDelivery = numofDelivery;
    }

    public List<Integer> getIdofpizza() {
        return this.idofpizza;
    }

    public void setIdofpizza(List<Integer> idofpizza) {
        this.idofpizza = idofpizza;
    }

    public delivery(int numofDelivery, List<Integer> idofpizza) {
        this.numofDelivery=numofDelivery;
        this.idofpizza=idofpizza;
    }
    
}


public class solution{
        public static void main( String args[] ) throws IOException{

        System.setIn(new FileInputStream(new File("b_little_bit_of_everything.in")));
        //System.setIn(new FileInputStream(new File("e_many_teams.in")));

        System.setOut(new PrintStream(new File("output_b.txt")));

        Scanner s = new Scanner(System.in);
        int m=s.nextInt();
        int t2=s.nextInt();
        int t3=s.nextInt();
        int t4=s.nextInt();
        
        //System.out.println("m:" + m+" t2:"+t2+" t3:"+t3+" t4:"+t4);

        List<PizzaIng> PizzaIngs = new ArrayList<PizzaIng>();

        for(int i=0;i<m;i++){
            int numpizza=s.nextInt();
            List<String> ingpizza = new ArrayList<String>();
            for(int j=0;j<numpizza;j++){
                ingpizza.add(s.next());
            }
            PizzaIng pza = new PizzaIng(numpizza, ingpizza);
            PizzaIngs.add(pza);

            //System.out.println(pza.numOfIng+" "+pza.getIngredients());
            
        }

        
        int pizzaremain = m, numofDel = 0; 
        List<delivery> deliveries = new ArrayList<delivery>();
        for (int i = 0; i < m; i++) {
            List<Integer> pizzaindx = new ArrayList<>();
            if (t2 != 0 && pizzaremain >= 2) {
                pizzaindx.add(i);
                pizzaindx.add(++i);
                deliveries.add(new delivery(2, pizzaindx));
                //i += 2;
                t2--;
                pizzaremain-=2;
                numofDel++;
            }
            else if (t3 != 0 && pizzaremain >= 3) {
                pizzaindx.add(i);
                pizzaindx.add(++i);
                pizzaindx.add(++i);
                deliveries.add(new delivery(3, pizzaindx));
                // i += 3;
                t3--;
                pizzaremain-=3;
                numofDel++;
            }
            else if (t4 != 0 && pizzaremain >= 4) {
                pizzaindx.add(i);
                pizzaindx.add(++i);
                pizzaindx.add(++i);
                pizzaindx.add(++i); // check
                deliveries.add(new delivery(4, pizzaindx));
                // i += 4;
                t4--;
                pizzaremain-=4;
                numofDel++;
            }
            
        }
       // System.out.println(deliveries);
        System.out.println(numofDel);
        for (delivery del : deliveries) {
            System.out.print(del.getNumofDelivery()); 
            for (int i = 0; i < del.numofDelivery; i++) {
                System.out.print(" " + del.idofpizza.get(i));
            }
            System.out.println("");
        }
        
        

        s.close();
    }
}
        