//Mark Valeriani 
import java.util.*;

public class vacuum {
    private static HashMap <Integer, String> room = new HashMap<Integer, String>();
    public static void main (String args[]){
        Scanner input = new Scanner(System.in);
        int roomNum;  // the room number they are in 
        String roomStatus; // the status of the room clean or dirty 
        boolean running = true, isThere; 
        room.put(1, "unknown");
        room.put(2, "unknown");
        room.put(3, "unknown");
        while (running == true){ // to keep the vacuum running 
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
            check(roomNum, roomStatus); // sends it to the check to see what its next move should be 
        }
    }
    public static void check(int roomNum, String roomSTatus){ // check to see if there are any other rooms 
        switch (roomNum) {
            case 1: //if we are in room 3 
                //method                
                break;
            case 2: //if we are in room two 
                //method
                break;
            default: //if it is room 3 
                //method
                break;
        }
        
    }
}