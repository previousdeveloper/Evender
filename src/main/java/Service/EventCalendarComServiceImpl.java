package Service;

import Interface.IEventCalendarComService;
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
public class EventCalendarComServiceImpl implements IEventCalendarComService {

    private Document doc = null;
    private List<EventModel> result = null;
    private EventModel eventModel = null;
    private String eventName = null;
    private String eventHrefUl = null;

    @Override
    public List<EventModel> getAllEvent() {
        try {
            doc = Jsoup.connect(Constant.EventCalendarBaseUrl + "etkinlikler").get();
            Elements eventNameElement = doc.select("div.views-field-field-etkinlik");
            result = new ArrayList<>();


            eventNameElement.parallelStream().forEach(element -> {
                eventModel = new EventModel();

                eventHrefUl = element.select("div.ozet-alani> a[href]").attr("href");
                eventName = element.text();

                eventModel.setEventName(eventName);

                eventModel.setUrl(Constant.EventCalendarBaseUrl + eventHrefUl);

                result.add(eventModel);

            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
