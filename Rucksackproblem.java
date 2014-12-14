import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by abp860 on 12.12.2014.
 */
public class Rucksackproblem {

    private final int k;
    private final List<Aktienpaket> aktienpakete;

    private int wert;
    private Set<Aktienpaket> loesung;

    public Rucksackproblem(int k) {
        this.k = k;
        this.aktienpakete = new ArrayList<Aktienpaket>();
        reset();
    }

    private void reset() {
        wert = -1;
        loesung = new HashSet<Aktienpaket>();
    }

    public void add(Aktienpaket aktienpaket) {
        aktienpakete.add(aktienpaket);
        reset();
    }

    public Set<Aktienpaket> getLoesung() {
        return loesung;
    }

    public int getWert() {
        return wert;
    }

    public Set<Aktienpaket> getAktienpakete() {
        Set<Aktienpaket> aktienpakete = new HashSet<Aktienpaket>();
        for (Aktienpaket paket : this.aktienpakete)
            aktienpakete.add(paket);
        return aktienpakete;
    }

    public void findeLoesung() {
        wert = findeLoesung(aktienpakete.size() - 1, k);
    }

    //findet den maximalen wert aller vorhandenen aktienpakete im rahmen der maximalen kosten
            //i ist der index der liste mit den paketen, k die kosten (die methode ist ueberladen und
            //startet mit dem index des letzten wertes der liste
            private int findeLoesung(int i, int k) {
                //abbruchbedingung wenn der index 0 unterschritten wird
                if (i < 0) {
                    return 0;
                }
                //wenn die kosten der aktienpakete an der stelle i groesser als die
                //maximalen kosten werden, wird der vorherige wert zurueckgegeben
                if (aktienpakete.get(i).getWeight() > k) {
                    return findeLoesung(i - 1, k);
                } else {
            //a ermittelt den wert ohne das aktuelle aktienpaket
            int a = findeLoesung(i - 1, k);
            //b ermittelt den wert inklusive des jetzigen aktienpaketes
            int b = findeLoesung(i - 1, k - aktienpakete.get(i).getWeight()) + aktienpakete.get(i).getValue();
            //wenn der wert mit dem jetzigen paket hoeher ist wird das paket der liste hinzugefuegt
            if (b > a)
                loesung.add(aktienpakete.get(i));
            return Math.max(a, b);
        }
    }


}
