import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Level {

    private HashMap<String, Room> nodeList;


    public Level() {
        nodeList = new HashMap<String, Room>();
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
                Room name = neighbors.get(x);
                output = output + name + ",";
            }
            return output;
        }

        public ArrayList<Room> getNeighborsList(){
            ArrayList<Room> roomsList = new ArrayList<>();
            roomsList = new ArrayList<Room>(neighbors.values());
            return roomsList;
        }

        public Room getNeighbor(String name) {
            Room neighborName = neighbors.get(name);
            return neighborName;
        }

        public ArrayList<Item> getItems() {
            return itemlist;
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