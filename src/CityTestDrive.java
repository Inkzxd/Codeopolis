import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class CityTestDrive{
    @Test
    public void test () {
        City city = new City ();
        assertTrue (city.buy (10,0));
    }

}

