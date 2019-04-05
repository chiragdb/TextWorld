import java.util.ArrayList;

public class Player {
    String name;
    String information;
    Level.Room currentRoom;
    ArrayList<Item> itemList;


    public Player(String name, String information) {
        this.name = name;
        itemList = new ArrayList<>();
        this.information = information;
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Level.Room newRoom) {
        this.currentRoom = newRoom;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public Item removeItem(String name) {
        for (Item item : itemList) {
            String itemName = item.getName();
            if (itemName.equals(name)) {
                itemList.remove(item);
            } else {
                System.out.println("The item that you are looking for is not in the list");
            }
        }
        return null;
    }

    public String getItems() {
        String output = "";
        for (Item item : itemList) {
            String itemName = item.getName();
            output = output + ", " + itemName;
        }
        return output;
    }


}