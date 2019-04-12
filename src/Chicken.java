import java.util.ArrayList;
import java.util.Collection;

public class Chicken extends Creature {

    public Chicken (String name, String information, Level.Room currentRoom){
        super(name, information, currentRoom);
    }

    public void move(){
        Collection collection = currentRoom.getNeighborsHash().values();
        ArrayList<Level.Room> neighborList = new ArrayList<>(collection);
        int listLength = neighborList.size();
        int rand = (int)(Math.random()* listLength);
        if (listLength < 1){
            return;
        }
        Level.Room room = neighborList.get(rand);
        setCurrentRoom(room);
    }
}
