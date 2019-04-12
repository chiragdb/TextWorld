import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Creature {
    String name;
    Level.Room currentRoom;
    String information;

    public Creature(String name, String information, Level.Room currentRoom) {
        this.currentRoom = currentRoom;
        this.name = name;
        this.information = information;
    }

    public String getName(){
        return name;
    }

    public void setName(String s){
        name = s;
    }

    protected void randomizeRoom(){
        ArrayList<Level.Room> list = new ArrayList<>();
        list = currentRoom.getNeighborsList();
        int listLength = list.size();
        int randIndex = (int)(Math.random() * listLength);
        Level.Room nextRoom = list.get(randIndex);
    }

    public abstract void move ();

    public Level.Room getCurrentRoom(){
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void changeRoom (Level.Room roomToMoveTo){
        setCurrentRoom(roomToMoveTo);
    }

    public String getInformation(){
        return information;
    }

    public void setInformation(String information){
        this.information = information;
    }


}

