package business;

import org.junit.jupiter.api.Test;
import ownUtil.PlausiException;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class FreizeitbadTest {

    @Test
    void testConstructor() throws PlausiException {
        String name = "Stadtbad";
        String oeffnungszeitStart = "7.00";
        String oeffnungszeitEnde = "17.00";
        String beckenlaenge = "25";
        String wasserTemparatur = "24";
        Freizeitbad freizeitbad = new Freizeitbad(name, oeffnungszeitStart, oeffnungszeitEnde, beckenlaenge, wasserTemparatur);
        BooleanSupplier supplier = () -> freizeitbad.getBeckenlaenge() == new Integer(beckenlaenge);
        assertTrue(supplier, "Beckenlaenge stimmt nicht");
    }
}