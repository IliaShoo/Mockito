import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

public class MessageSenderTest {

    @Test
    void sendTestRussian() {

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

    @Test
    void sendTestEnglish(){
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.44.183.149")).
                thenReturn(new Location("New York",Country.USA,"10th avenue",32));

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        //не понимаю как переписать это правильно.
        String actual = String.valueOf(Mockito.when(localizationService.locale(Country.USA)).
                thenReturn("Welcome"));

        String excpected = "Welcome";

        Assertions.assertEquals(excpected, actual);
    }

    @Test
    void LocationByIp(){
        GeoServiceImpl geoService = new GeoServiceImpl();
        String ip = "172.0.32.11";
        Location excpected = new Location("Moscow",Country.RUSSIA,"Lenina", 15);
        Location actual = geoService.byIp(ip);
        //выдаёт ошибку. Не понимаю как исправить.
        Assertions.assertEquals(excpected,actual);


    }

}