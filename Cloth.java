import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


abstract class Cloth {
    protected String type;
    protected String color;
    protected int condition; 
    protected int wearCount;

    public Cloth(String type, String color, int condition) {
        this.type = type;
        this.color = color;
        this.condition = condition;
        this.wearCount = 0;
    }

    public abstract String getInfo();

    public void wear() throws Exception {
        if (condition <= 0) throw new Exception("HAHAHA  This dress cannot be worn");
        wearCount++;
        condition--;
    }

    public void wash() {
        wearCount = 0;
    }

    public void repair() {
        if (condition <= 0) return;
        condition += 2; 
    }

    public boolean needsWashing() {
        return wearCount >= 3; 
    }

    public boolean needsRepair() {
        return condition < 3; 
    }

    public boolean isWornOut() {
        return condition <= 0; 
    }
}

//Wardrobe



class Wardrobe {
    List<Cloth> cabinet;

    public Wardrobe() {
        this.cabinet = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        cabinet.add(cloth);
    }

    public void printInfo() {
        for (Cloth cloth : cabinet) {
            System.out.println(cloth.getInfo());
        }
    }

    public void washAllClothes() {
        for (Cloth cloth : cabinet) {
            if (cloth.needsWashing()) {
                cloth.wash();
            }
        }
    }

    public void repairAllClothes() {
        for (Cloth cloth : cabinet) {
            if (cloth.needsRepair()) {
                cloth.repair();
            }
        }
    }

    public List<Cloth> purge() {
        List<Cloth> removedClothes = new ArrayList<>();
        Iterator<Cloth> iterator = cabinet.iterator();
        
        while (iterator.hasNext()) {
            Cloth cloth = iterator.next();
            if (cloth.isWornOut()) {
                removedClothes.add(cloth);
                iterator.remove();
            }
        }
        
        return removedClothes;
    }}

    //Overwear

    class Overwear extends Cloth {
        public Overwear(String type, String color, int condition) {
            super(type, color, condition);
        }
    
        public Overwear() {
            this("shirt", "white", 5); }
    
        @Override
        public String getInfo() {
            return "Overwear: " + type + ", color: " + color + ", condition: " + condition;
        }
    }

    //Underwear

    class Underwear extends Cloth {
        public Underwear(String type, String color, int condition) {
            super(type, color, condition);
        }
    
        public Underwear() {
            this("briefs", "white", 5);
        }
    
        @Override
        public String getInfo() {
            return "Underwear: " + type + ", color: " + color + ", condition: " + condition;
        }
    }
    