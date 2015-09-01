package Controller;

import Service.IEventCalendarCom;
import Service.IEventComService;
import Service.IZorluCenter;
import Util.JsonTransformer;

import static spark.Spark.get;

/**
 * Created by previousdeveloper on 1.09.2015.
 */
public class EventController {

    public EventController(IEventComService eventComService, IEventCalendarCom eventCalendarCom, IZorluCenter zorluCenter) {

        get("/city/:city", "application/json", (request, response) -> {
            String reqCity = request.params(":city");
            return eventComService.getByCity(reqCity);
        }, new JsonTransformer());

        get("/event", "application/json", (request, response) -> {

            return eventCalendarCom.getAllEvent();
        }, new JsonTransformer());

        get("/zorluevent", "application/json", (request, response) -> {

            return zorluCenter.getAllEvent();
        }, new JsonTransformer());
    }


}
