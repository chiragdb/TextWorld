public class Item {
    String name;
    String information;

    public Item(String name, String information) {
        this.name = name;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setDescription(String information) {
        this.information = information;
    }

}