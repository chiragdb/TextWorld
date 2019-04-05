import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Creature {
    String name;
    Level.Room currentRoom;
    private Player player;

    public String getName(){
        return name;
    }

    public void setName(String s){
        name = s;
    }

    public Creature(Player player, Level.Room currentRoom) {
        this.currentRoom = currentRoom;
        this.player = player;
    }

    protected void randomizeRoom(){
        ArrayList<Level.Room> list = new ArrayList<>();
        list = currentRoom.getNeighborsList();
        int listLength = list.size();
        int randIndex = (int)(Math.random() * listLength);
        Level.Room nextRoom = list.get(randIndex);
    }

    public abstract void move (Level.Room roomToMoveTo);
}

