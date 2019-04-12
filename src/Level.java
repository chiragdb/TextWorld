import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Level {

    private HashMap<String, Room> nodeList;
    private Player player;
    private ArrayList <Creature> creatureList;

    public Level() {
        nodeList = new HashMap<String, Room>();
        creatureList = new ArrayList<>();
    }

    public void addCreature(Creature creature){
        creatureList.add(creature);
    }

    public Creature removeCreature(String name){
        for (int c = 0; c < creatureList.size(); c++){
            Creature creature = creatureList.get(c);
            String creatureName = creature.getName();
            if (creatureName.equals(name)){
                return creatureList.remove(c);
            }
        }
        return null;
    }

    public String showCreaturePositions(){
        String output = "";
        for (Creature c : creatureList){
            String creatureName = c.getName();
            Level.Room creatureRoom = c.getCurrentRoom();
            String creatureCurrentRoom = creatureRoom.getName();
            output = output + creatureName + " -> " + creatureCurrentRoom + ". ";
        }
        return output;
    }

    public void removeCreature(Creature c){
        if (creatureList.contains(c)){
            creatureList.remove(c);
        } else {
            return;
        }
    }

    public String showCreatures(Level.Room room){
        String output = "";
        for (Creature c : creatureList){
            Level.Room creatureRoom = c.getCurrentRoom();
            String creatureName = c.getName();
            if (creatureRoom.equals(room)){
                output = output + creatureName + " ";
            }
        }
        return output;
    }

    public void creatureInformation(){
        for (Creature c : creatureList){
            int listSize = creatureList.size();
            System.out.println("Number of animals is " + listSize);
            c.move();
        }
    }

    public void addRoom(String name, String information) {
        Room newNode = new Room(name, information);
        nodeList.put(name, newNode);
    }

    public void addDirectedEdge(String namePrimary, String nameSecondary) {
        Room node1 = getRoom(namePrimary);
        Room node2 = getRoom(nameSecondary);
        node1.addNeighbor(node2);
    }

    public void addUndirectedEdge(String namePrimary, String nameSecondary) {
        Room node1 = getRoom(namePrimary);
        Room node2 = getRoom(nameSecondary);

        node1.addNeighbor(node2);
        node2.addNeighbor(node1);
    }

    public Room getRoom(String name) {
        Room val = nodeList.get(name);
        return val;
    }

    public class Room {
        ArrayList<Item> itemlist;
        ArrayList<Creature> creatureList;
        private String name;
        private String information;
        private HashMap<String, Room> neighbors;

        public Room(String name, String information) {
            neighbors = new HashMap<>();
            this.information = information;
            this.name = name;
            itemlist = new ArrayList<>();
            creatureList = new ArrayList<>();
        }

        public String getInformation() {
            return information;
        }

        public void setInformation(String info) {
            information = info;
        }

        public String getName() {
            return name;
        }

        public void addNeighbor(Room n) {
            String name = n.getName();
            neighbors.put(name, n);
        }

        public String getNeighborNames() {
            String output = "";
            for (String x : neighbors.keySet()) {
                Room room = neighbors.get(x);
                String stringName = room.getName();
                output = output + name + " ";
            }
            return output;
        }

        public ArrayList<Room> getNeighborsList(){
            ArrayList<Room> roomsList = new ArrayList<Room>();

            for (String n : neighbors.keySet()){
                Room room = neighbors.get(n);
                roomsList.add(room);
            }
            return roomsList;
        }

        public Room getNeighbor(String name) {
            Room neighborName = neighbors.get(name);
            return neighborName;
        }

        public HashMap getNeighborsHash(){
            return neighbors;
        }


        public String getItems() {
            String output = "";
            for (Item i : itemlist){
                String itemName = i.getName();
                output = output + itemName + " ";
            }
            return output;
        }

        public void addItem(Item item) {
            itemlist.add(item);
        }

        public Item removeItem(String name) {
            for (Item item : itemlist) {
                String itemName = item.getName();
                if (itemName.equals(name)) {
                    itemlist.remove(item);
                    return item;
                } else {
                    System.out.println("The item that you are looking for is not in the list");
                }
            }
            return null;
        }

        public ArrayList<Creature> getCreatures() {
            return creatureList;
        }

        public void addCreature(Creature creature) {
            creatureList.add(creature);
        }

        public Creature removeCreature(String name) {
            for (Creature creature : creatureList) {
                String creatureName = creature.getName();
                if (creatureName.equals(name)) {
                    creatureList.remove(creature);
                    return creature;
                } else {
                    System.out.println("No such creature");
                }
            }
            return null;
        }
    }

}