/**
 * Created by abp860 on 12.12.2014.
 */
public class Aktienpaket {

    private final String name;
    private final int value;
    private final float performance;
    private final int weight;


    public Aktienpaket(String name, int weight, float performance) {
        this.name = name;
        this.weight = weight;
        this.performance = performance;
        this.value = weight + (int) (weight * performance);
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }


    public String getName() {
        return name;
    }
}
