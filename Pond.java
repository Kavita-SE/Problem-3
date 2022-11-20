package Test;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class Activity{
    synchronized void performActivity(CopyOnWriteArrayList<Fish> fishList){

        Random randomIndex = new Random();
        int fish1 = randomIndex.nextInt(fishList.size());
        int fish2 = randomIndex.nextInt(fishList.size());

        while(fish1 == fish2)
            fish2 = new Random().nextInt(fishList.size());

        if(fishList.get(fish1).getGender().equals("M")){
            if(fishList.get(fish2).getGender().equals("M")){
                System.out.println("Both Male Fishes having indices "+ fish1 + " and " + fish2 + " are killing each other");
                fishList.remove(fish1);
                fishList.remove(fish2);
            }
            else if(fishList.get(fish2).getGender().equals("F")){
                int loc1 = randomIndex.nextInt(fishList.size());
                int loc2 = randomIndex.nextInt(fishList.size());
                while(loc1 == loc2)
                    loc2 = randomIndex.nextInt(fishList.size());
                System.out.println("Spawning two new fishes at indices "+fish1 + " and "+ fish2);
                fishList.add(loc1, new Fish("M"));
                fishList.add(loc2, new Fish("F"));

            }
        }
        else{
            if(fishList.get(fish2).getGender().equals("M")){
                int loc1 = randomIndex.nextInt(fishList.size());
                int loc2 = randomIndex.nextInt(fishList.size());
                while(loc1 == loc2)
                    loc2 = randomIndex.nextInt(fishList.size());
                System.out.println("Spawning two new fishes at indices "+fish1 + " and "+ fish2);
                fishList.add(loc1, new Fish("F"));
                fishList.add(loc2, new Fish("M"));
            }
            else if(fishList.get(fish2).getGender().equals("F")){
                System.out.println("Killing fish having index "+fish2);
                fishList.remove(fish2);
            }
        }
    }
}
class Pond{
    CopyOnWriteArrayList<Fish> fishList;
    Pond(){
        fishList = new CopyOnWriteArrayList<Fish>();

        for(int i=1; i<=10; i++){
            fishList.add(new Fish("M"));
            fishList.add(new Fish("F"));
        }

    }

    int getFishListSize(){
        return fishList.size();
    }

}
