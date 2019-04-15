import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Level root = new Level();

        Player player = new Player("Chirag", "tall");

        Item firstItem = new Item("baseball bat", "very long");
        Item secondItem = new Item("baseball", "white");
        Item thirdItem = new Item("hat", "blue");

        root.addRoom("hall", "a long, dank hallway");
        root.addRoom("closet", "a dark, dark, closet");
        root.addRoom("dungeon", "a smelly dungeon");
        root.addRoom("bathroom", "very white");
        root.addRoom("bedroom", "master bedroom");

        root.addDirectedEdge("hall", "dungeon");
        root.addDirectedEdge("hall", "bathroom");
        root.addDirectedEdge("hall", "closet");
        root.addDirectedEdge("bedroom", "bathroom");


        Level.Room currentRoom = root.getRoom("hall");

        player.setCurrentRoom(currentRoom);

        String response = " ";
        Scanner in = new Scanner(System.in);

        Level.Room room1 = root.getRoom("hall");
        Level.Room room2 = root.getRoom("dungeon");
        Level.Room room3 = root.getRoom("bathroom");

        room1.addItem(firstItem);
        room2.addItem(secondItem);
        room3.addItem(thirdItem);

        Popstar popstar = new Popstar("Popstar Paul", "Very fast", room2, player);
        Chicken chicken = new Chicken("Chicken Craig", "Extremely Loud", room1);
        Wumpus wumpus = new Wumpus("Wumpus Willy", "Very slow", room3, player);


        do {
            System.out.println("You are currently in the " + player.getCurrentRoom().getName());

            System.out.println("What would you like to do? Go, Look, Pick, Check Add, or Quit. Type help for information about the commands");
            response = in.nextLine();


            if (response.substring(0, 2).equals("go")) {
                String s = getSpecificString(response);
                player.setCurrentRoom(root.getRoom(s));
                currentRoom = root.getRoom(s);

            }
            if (response.substring(0,4).equals("look")) {
                System.out.println("You are currently in the " + currentRoom.getName());
                System.out.println("You can go to the " + currentRoom.getNeighborNames());
                System.out.println("The items that you have on you are" + player.getItems());
                Level.Room room = player.currentRoom;
                System.out.println("The items in the room are " + room.getItems());
                System.out.println("The animals in the room are " + root.showCreatures(room));


            }
            if (response.substring(0,3).equals("add")) {
                String room = getSpecificString(response);
                System.out.print("Please add a description");
                String information = in.nextLine();
                root.addRoom(room, information);
                String name = currentRoom.getName();
                root.addDirectedEdge(name, room);

            }
            if (response.substring(0,4).equals("pick")) {
                String item = getSpecificString(response);
                Item i = new Item(item, "unknown");
                Level.Room room = player.getCurrentRoom();
                room.removeItem(item);
                player.addItem(i);
            }
            if (response.substring(0, 5).equals("Check")){
                String s = root.showCreaturePositions();
                System.out.println(s);
            }
            if (response.substring(0,4).equals("drop")) {
                String item = getSpecificString(response);
                Item taken = player.removeItem(item);
                currentRoom.addItem(taken);
            }
            if (response.equals("quit")) {
                break;
            } if (response.equals("help")) {
                System.out.println(" to go to a new room, type 'go <roomName>'");
                System.out.println(" to add a new room, type 'add <roomName>'");
                System.out.println(" to see all neighbors, type 'look' ");
                System.out.println(" to quit, type quit");
                System.out.println(" to pick up an item, type 'pick <itemName>'");
                System.out.println(" to drop an item, type 'drop <itemName>'");
            }

        } while (!response.equals("quit"));

    }


    private static String getSpecificString(String ans) {
        String output = "";
        int first = ans.indexOf("<");
        int second = ans.indexOf(">");
        output = ans.substring(first + 1, second);
//        String output = "";
//        for (int letter = 0; letter < ans.length(); letter++) {
//            String partial = ans.substring(letter, letter + 1);
//            if (partial.equals("<")) {
//                int last = getLast(ans, letter + 1);
//                output = ans.substring(letter + 1, last);
//                return output;
//            }
//        }
//        return output;
        return output;
    }


}