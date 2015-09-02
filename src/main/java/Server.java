import Controller.EventController;
import DI.Module;
import Interface.IEventCalendarComService;
import Interface.IEventComService;
import Interface.IZorluCenterService;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by previousdeveloper on 1.09.2015.
 */


public class Server {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new Module());

        //Resolve DI
        IEventCalendarComService eventCalenderComService = injector.getInstance(IEventCalendarComService.class);
        IEventComService eventComService = injector.getInstance(IEventComService.class);
        IZorluCenterService zorluCenterService = injector.getInstance(IZorluCenterService.class);

        new EventController(eventComService, eventCalenderComService, zorluCenterService);
    }


}




