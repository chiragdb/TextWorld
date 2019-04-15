import java.util.ArrayList;
import java.util.HashMap;

public class Wumpus extends Creature{
    private Player player;

    public Wumpus (String name, String information, Level.Room currentRoom, Player player){
        super(name, information, currentRoom);
        this.player = player;
    }

    public void move(){
        ArrayList<Level.Room> neighbors = new ArrayList<>(currentRoom.getNeighborsHash().values());
        int listSize = neighbors.size();
        if (listSize < 1){
            System.out.println("No neighboring rooms exist");
            return;
        }
        Level.Room playerRoom = player.getCurrentRoom();
        ArrayList<Level.Room> nearPlayer = playerRoom.getNeighborsList();
        ArrayList<Level.Room> possibleRooms = possibleMoves(nearPlayer, neighbors);

        int possibleRoomsSize = possibleRooms.size();
        int wNeighborsSize = neighbors.size();
        int r = (int)(Math.random() * possibleRoomsSize);
        Level.Room room = possibleRooms.get(r);
        setCurrentRoom(room);


    }

    private ArrayList<Level.Room> possibleMoves(ArrayList<Level.Room> nearPlayer, ArrayList<Level.Room> neighbors) {
        ArrayList<Level.Room> newNeighbors = neighbors;
        for (int a = 0; a < nearPlayer.size(); a++){
            for (int b = 0; b < neighbors.size(); b++){
                Level.Room p = nearPlayer.get(a);
                Level.Room w = neighbors.get(b);
                if (p.equals(w)){
                    newNeighbors.remove(w);
                }
            }
        }

        return newNeighbors;
    }

}