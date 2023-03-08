import java.util.Random;

 public class House {
    public  int numHouse;
    public String[] type = {"Gryffindor", "Ravenclaw", "Slytherin", "Hufflepuff"};
    public House(){
        chooseHouse();
    }

    public void chooseHouse() {
        Random random = new Random();
        int x = random.nextInt(4) + 1;
        if (x == 1) {
            System.out.println("_SortingHat : 'It's obvious, your house is Gryffindor !' ");
            this.numHouse = x - 1;
        } else if (x == 2) {
            System.out.println("_SortingHat: 'It's obvious, your house is Ravenclaw' ! ");
            this.numHouse = x - 1;
        } else if (x == 3) {
            System.out.println("_SortingHat: 'It's obvious, your house is Slytherin' !' ");
            this.numHouse = x - 1;
        } else if (x == 4) {
            System.out.println("_SortingHat:  'It's obvious, your house is Hufflepuff !' ");
            this.numHouse = x - 1;
        }
        GameLogic.anythingtoContinue();

    }
}
