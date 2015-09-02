import Controller.EventController;
import Service.EventCalendarComServiceImpl;
import Service.EventComServiceImpl;
import Service.IZorluCenterServiceImpl;

/**
 * Created by previousdeveloper on 1.09.2015.
 */


public class Server {

    public static void main(String[] args) {

        new EventController(new EventComServiceImpl(), new EventCalendarComServiceImpl(), new IZorluCenterServiceImpl());
    }


}




