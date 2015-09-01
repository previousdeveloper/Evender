package Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by previousdeveloper on 1.09.2015.
 */
public class EventComServiceImpl implements IEventComService {

    @Override
    public Dictionary<String, Object> getByCity(String city) {
        Document doc = null;
        Dictionary<String, Object> result = null;
        try {
            doc = Jsoup.connect("http://www.etkinlik.com.tr/" + city).get();
            Elements eventName = doc.select("td.adi > a");


            result = new Hashtable<>();
            for (Element e : eventName) {

                result.put(e.text(), e.attr("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}
