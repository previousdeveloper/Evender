package Service;

import Interface.IEventComService;
import Model.EventModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by previousdeveloper on 1.09.2015.
 */
public class EventComServiceImpl implements IEventComService {


    private Document doc = null;
    private EventModel eventModel = null;
    private String eventName = null;
    private String elementUrl = null;
    private List<EventModel> result = null;

    @Override
    public List<EventModel> getByCity(String city) {

        try {

            doc = Jsoup.connect(Constant.EventComBaseUrl + city).get();
            Elements eventNameElement = doc.select("td.adi > a");
            result = new ArrayList<>();

            eventNameElement.parallelStream().forEach(element -> {
                eventModel = new EventModel();

                eventName = element.text();
                elementUrl = element.attr("href");

                eventModel.setEventName(eventName);
                eventModel.setUrl(elementUrl);


                result.add(eventModel);
            });


        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}
