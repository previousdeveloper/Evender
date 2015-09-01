package Controller;

import Service.IEventCalendarCom;
import Service.IEventComService;
import Service.IZorluCenter;
import Util.JsonTransformer;

import java.util.Dictionary;

import static spark.Spark.get;

/**
 * Created by previousdeveloper on 1.09.2015.
 */
public class EventController {

    public EventController(IEventComService eventComService, IEventCalendarCom eventCalendarCom, IZorluCenter zorluCenter) {

        new ServerConfiguration();

        get("/city/:city", "application/json", (request, response) -> {
            String reqCity = request.params(":city");
            Dictionary<String, Object> result = eventComService.getByCity(reqCity);

            if (result == null) {
                response.status(404);
            }

            return result;

        }, new JsonTransformer());

        get("/event", "application/json", (request, response) -> {

            Dictionary<String, Object> result = eventCalendarCom.getAllEvent();

            if (result == null) {

                response.status(404);
            }

            return result;

        }, new JsonTransformer());

        get("/zorluevent", "application/json", (request, response) -> {

            Dictionary<String, Object> result = zorluCenter.getAllEvent();
            if (result == null) {

                response.status(404);
            }


            return result;
        }, new JsonTransformer());

    }


}





