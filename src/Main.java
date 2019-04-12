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

        root.addDirectedEdge("hall", "dungeon");
        root.addUndirectedEdge("hall", "closet");

        Level.Room currentRoom = root.getRoom("hall");
        currentRoom.addItem(firstItem);
        currentRoom.addItem(secondItem);
        currentRoom.addItem(thirdItem);

        String response = " ";
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("You are currently in the " + currentRoom.getName());

            System.out.println("What would you like to do? Go, Look, Add, or Quit. Type help for information about the commands");
            response = in.nextLine();


            if (response.substring(0, 2).equals("go")) {
                String s = getSpecificString(response);
                currentRoom = root.getRoom(s);
            }
            if (response.substring(0,4).equals("look")) {
                System.out.println("You are currently in the " + currentRoom.getName());
                System.out.println("You can go to the " + currentRoom.getNeighborNames());

            }
            if (response.substring(0,3).equals("add")) {
                String room = getSpecificString(response);
                System.out.print("Please add a description");
                String information = in.nextLine();
                root.addRoom(room, information);
                root.addDirectedEdge(currentRoom.getName(), room);

            }
            if (response.substring(0,4).equals("pick")) {
                String item = getSpecificString(response);
                Item taken = currentRoom.removeItem(item);
                player.addItem(taken);
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

    private static int getLast(String ans, int val) {
        for (int letter = val; letter < ans.length(); letter++) {
            String partial = ans.substring(letter, letter + 1);
            if (partial.equals(">")) {
                return letter;
            }
        }
        return -1;
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