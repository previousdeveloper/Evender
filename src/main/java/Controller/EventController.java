package Controller;

import Interface.IEventCalendarComService;
import Interface.IEventComService;
import Interface.IZorluCenterService;
import Model.EventModel;
import Util.JsonTransformer;

import java.util.Dictionary;
import java.util.List;

import static spark.Spark.get;

/**
 * Created by previousdeveloper on 1.09.2015.
 */
public class EventController {

    public EventController(IEventComService eventComService, IEventCalendarComService eventCalendarCom, IZorluCenterService zorluCenter) {

        new ServerConfiguration();

        get("/city/:city", "application/json", (request, response) -> {
            String reqCity = request.params(":city");
            List<EventModel> result = eventComService.getByCity(reqCity);

            if (result == null) {
                response.status(404);
            }

            return result;

        }, new JsonTransformer());

        get("/event", "application/json", (request, response) -> {

            List<EventModel> result = eventCalendarCom.getAllEvent();

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





