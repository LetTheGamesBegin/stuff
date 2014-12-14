import junit.framework.TestCase;
import org.junit.Test;

public class RucksackproblemTest extends TestCase {

    public static int K = 150;

    @Test
    public void testAdd() throws Exception {
    Rucksackproblem rucksackproblem = new Rucksackproblem(K);
        rucksackproblem.add(new Aktienpaket("Legoland", 33, 0.7F));
        rucksackproblem.add(new Aktienpaket("Mosters Inc.", 38, -0.1F));
        rucksackproblem.add(new Aktienpaket("Die Firma", 94, 0.6F));
        rucksackproblem.add(new Aktienpaket("Pangea", 62, 0.8F));
        rucksackproblem.add(new Aktienpaket("Enterprise AG", 28, 0.2F));
        rucksackproblem.add(new Aktienpaket("Stern des Suedens", 20, 1.1F));
        rucksackproblem.add(new Aktienpaket("Astra", 58, -0.05F));
        rucksackproblem.add(new Aktienpaket("Maritim e.V.", 48, 0.4F));
        rucksackproblem.findeLoesung();
        System.out.println(rucksackproblem.getWert());
        for(Aktienpaket paket : rucksackproblem.getLoesung())
            System.out.println(paket.getName());
    }
}