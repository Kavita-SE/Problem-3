package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InfinitePond extends Thread{

    CopyOnWriteArrayList<Fish> fishes ;
    @Override
    public void run(){
        try {
            while(fishes.size()>1) {
                Activity act = new Activity();
                act.performActivity(fishes);
                System.out.println("Thread performed this meeting : "+ Thread.currentThread().getName());
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    InfinitePond(Pond p){
        this.fishes = p.fishList;
    }

    public static void main(String[] args) {
        Pond p = new Pond();
        InfinitePond thread1 = new InfinitePond(p);
        InfinitePond thread2 = new InfinitePond(p);
        InfinitePond thread3 = new InfinitePond(p);
        InfinitePond thread4 = new InfinitePond(p);
        InfinitePond thread5 = new InfinitePond(p);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

