//Mark Valeriani 
import java.util.*;

public class vacuum {
    private static HashMap <Integer, String> room = new HashMap<Integer, String>();
    private static boolean running = true;
    public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        int roomNum;  // the room number they are in 
        String roomStatus; // the status of the room clean or dirty 
        boolean isThere; 
        room.put(1, "unknown");
        room.put(2, "unknown");
        room.put(3, "unknown");
        while (running == true){ // to keep the vacuum running 
            System.out.println("");
            System.out.println("What room am I in? ");
            roomNum = input.nextInt(); // puts the room number in 
            while (roomNum > 3 || roomNum <= 0 ){ // makes sure the room number is 1 2 or 3 
                System.out.println("Pick room 1,2 or 3. ");
                roomNum = input.nextInt();
            }
            System.out.println("Is the room clean or dirty? "); // checking to see if the rooms are dirty or clean 
            roomStatus = input.next();
            isThere = room.containsKey((roomNum)); // sees if we already entered the room just incase 
            if (isThere == true){ // if we did it is going to change the value of that room 
                room.replace(roomNum, roomStatus);
            }
            else { // if not we just store that room 
                room.put(roomNum, roomStatus);
            }
            check(roomNum); // sends it to the check to see what its next move should be 
        }
    }
    public static void check(int roomNum){ // check to see if there are any other rooms 
        switch (roomNum) {
            case 1: //if we are in room 3 
                //System.out.println("Got here at case 1");
                roomOne();//method                 
                break;
            case 2: //if we are in room two 
                //System.out.println("Got here at case 2");
                roomTwo();//method
                break;
            default: //if it is room 3 
                //System.out.println("Got here at case 3");
                roomThree();//method
                break;
        }
        
    }
    public static void roomOne(){ // going into room one checking whether it is clean or dirty 
        if (room.get(1).equals("dirty")){// if it is dirty it will clean it 
            System.out.println("Clean");
            room.replace(1, "clean");
        }
        if (room.get(1).equals("clean") && room.get(2).equals("clean") && room.get(3).equals("clean")){ // if all are clean then it will stop 
            System.out.println("My job is done!");
            running = false;
        }else { // if all are not clean it will make moves 
            if (room.get(1).equals("clean")){
                if(room.get(2).equals("clean")){
                    System.out.println("Move to the right twice");
                }else if (room.get(2).equals("dirty") || room.get(2).equals("unknown")) {
                    System.out.println("Move to the right.");
                }
            }
        }
    }
    public static void roomTwo(){
        if (room.get(2).equals("dirty")){
            System.out.println("Cleaning!");
            room.replace(2, "clean");
        }
        if (room.get(1).equals("clean") && room.get(2).equals("clean") && room.get(3).equals("clean")){
            System.out.println("My job is done!");
            running = false;
        }else {
            if (room.get(2).equals("clean")){
                if(room.get(3).equals("clean")){
                    System.out.println("Move to the left.");
                }else {
                    System.out.println("Move to the right.");
                }
            }
        }
    }
    public static void roomThree(){
        if (room.get(3).equals("dirty")){
            System.out.println("Cleaning!");
            room.replace(3, "clean");
        }
        if (room.get(1).equals("clean") && room.get(2).equals("clean") && room.get(3).equals("clean")){
            System.out.println("My job is done!");
            running = false;
        }else {
            if (room.get(3).equals("clean")){
                if(room.get(2).equals("clean")){
                    System.out.println("Move the the left twice.");
                }else {
                    System.out.println("Move to the left.");
                }
            }
        }
    }
}