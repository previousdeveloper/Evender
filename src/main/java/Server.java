import Controller.EventController;
import Service.EventCalendarComImpl;
import Service.EventComServiceImpl;
import Service.IZorluCenterImpl;

/**
 * Created by previousdeveloper on 1.09.2015.
 */


public class Server {

    public static void main(String[] args) {


        new EventController(new EventComServiceImpl(),new EventCalendarComImpl(),new IZorluCenterImpl());
    }


}




