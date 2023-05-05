package FirstExampleParsing.csvRead.csv;

public class StructureCSV {
    private final String name;
    private final String artucul;
    private final String price;
    private int item;

    public StructureCSV(String name, String artucul, String price, int item) {
        this.name = name;
        this.artucul = artucul;
        this.price = price;
        this.item = item;
    }


    public String getName() {
        return name;
    }

    public String getArtucul() {
        return artucul;
    }

    public String getPrice() {
        return price;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "name= " + name + ", artucul= " + artucul + ", price= " + price + ", item= " + item;
    }
}
