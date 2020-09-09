import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    IRoom location;
    boolean done = false;
    Scanner scanner;

    public Main(){
        IRoom nurseDesk = new NurseDesk("Nurse Desk", "The main nursing desk. Usually tidy, the desk is covered with paper and obscured by desk. A live eletcrical wire dangles percariously close overhead.");
        IRoom room101 = new Room101("Room 101", "A room for patients in intensive care. There is less debris in this room, but the chairs are overturned and there is broken glass from the window on the floor.");
        IRoom room102 = new Room102("Room 102", "A room for recovering mothers. This room seems fairly unaffected by the tornado, except for the pervasive dust.");
        IRoom room103 = new Room103("Room 103", "A room for general needs. Most of the ceiling tiels have fallen to the floor and all of the windows are blown out. You can hear the hiss of gas.");

        nurseDesk.setNorth(room101);
        room101.setSouth(nurseDesk);
        nurseDesk.setEast(room102);
        room102.setWest(nurseDesk);
        nurseDesk.setWest(room103);
        room103.setEast(nurseDesk);

        location = nurseDesk;

        scanner = new Scanner(System.in);

        String[] goEastStrings = {"e", "east", "go east"};
        String[] goWestStrings = {"w", "west", "go west"};
        String[] goNorthStrings = {"n", "north", "go north"};
        String[] goSouthStrings = {"s", "south", "go south"};

        List<Action> actions = new ArrayList<Action>();
        
        actions.add(new Action(goEastStrings, ()->move(()->location.getEast())));
        actions.add(new Action(goWestStrings, ()->move(()->location.getWest())));
        actions.add(new Action(goNorthStrings, ()->move(()->location.getNorth())));
        actions.add(new Action(goSouthStrings, ()->move(()->location.getSouth())));
        

        while(!done){
            System.out.println("Room: " + location.getName());
            System.out.println(location.getDescription());
            System.out.println("What would you like to do?");
            String input = scanner.nextLine().trim().toLowerCase();
            boolean foundSuccess = false;
            for(int i = 0; i < actions.size() && !foundSuccess; i++){
                Action action = actions.get(i);
                if(Arrays.stream(action.validInput).anyMatch(s->s.equals(input))){
                    action.action.go();
                    foundSuccess = true;
                    continue;
                }
            }
            if(!foundSuccess){
                fail("I didn't understand that input");
                continue;
            }
        }
    }

    public void move(IGetRoom getRoom){
        IRoom next = getRoom.getRoom();
        if(next == null)
        {
            fail("You can't go that way");
            return;
        }
        else{
            location = next;
        }
    }
    
    public void fail(String errorString){
        System.out.println(errorString);

    }
}