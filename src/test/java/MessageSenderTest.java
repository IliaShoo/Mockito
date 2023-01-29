import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

public class MessageSenderTest {

    @Test
    void sendTest() {

        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.32.11")).
                thenReturn(new Location("Moscow",Country.RUSSIA,"Lenina",15));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
         String actual = String.valueOf(Mockito.when(localizationService.locale(Country.RUSSIA)).
                thenReturn("Добро пожаловать"));

        String excpected = "Добро пожаловать";

        //тест не проходит
        Assertions.assertEquals(excpected, actual);

    }

}