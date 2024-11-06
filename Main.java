public class Main {

    public static void main(String[] args) {
    Wardrobe w = new Wardrobe();
    w.addCloth(new Overwear("skirt", "blue", 6));
    w.addCloth(new Underwear("boxer briefs", "navy", 6));
    w.addCloth(new Overwear());
    w.addCloth(new Underwear());
    
    System.out.println("------ Wardrobe contains:");
    w.printInfo();
    
    for (int i = 0; i < 6; i++) {
    for (Cloth cloth : w.cabinet) {
    try {
    cloth.wear();
    } catch (Exception e) {
    //System.out.println(cloth.getInfo() + " and must be washed");
    }
    }
    w.washAllClothes();
    }
    System.out.println("\n------ Wardrobe after wearing 6 times and 6 washing:");
    w.printInfo();
    
    w.repairAllClothes();
    System.out.println("\n------ Wardrobe after repairing all clothes:");
    w.printInfo();
    
    System.out.println("\n------ Discarded clothes:");
    for (Cloth cloth: w.purge())
    System.out.println(cloth.getInfo());
    
    System.out.println("\n------ Wardrobe after purging:");
    w.printInfo();
    }
    }