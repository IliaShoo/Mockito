import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.mockito.Mockito.when;

public class MessageSenderTest {

    @Test
    void sendTestRussian() {

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        String actual = localizationService.locale(Country.RUSSIA);

        String excpected = "Добро пожаловать";

        Assertions.assertEquals(excpected, actual);
    }

    @Test
    void sendTestEnglish() {

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        String actual = localizationService.locale(Country.USA);

        String excpected = "Welcome";

        Assertions.assertEquals(excpected, actual);
    }

    @Test
    void LocationByIp() {
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        String ip = "172.0.32.11";
        when(geoService.byIp(ip)).thenReturn(new Location("Moscow",Country.RUSSIA,"Lenina",15));

        Location excpectedLocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Location actualLocation = geoService.byIp(ip);

        Country actual = actualLocation.getCountry();
        Country excpected = excpectedLocation.getCountry();

        Assertions.assertEquals(excpected, actual);
    }
}