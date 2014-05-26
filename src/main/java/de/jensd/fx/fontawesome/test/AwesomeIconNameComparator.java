package de.jensd.fx.fontawesome.test;

import de.jensd.fx.fontawesome.AwesomeIcon;
import java.util.Comparator;

/**
 *
 * @author Jens Deters
 */
public class AwesomeIconNameComparator implements Comparator<AwesomeIcon> {

    @Override
    public int compare(AwesomeIcon o1, AwesomeIcon o2) {
        if(o1 != null && o2 != null){
            return o1.name().compareTo(o2.name());
        }
        return 0;
    }
}
