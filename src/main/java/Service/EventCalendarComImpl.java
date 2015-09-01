package Service;

import Const.Constant;
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
public class EventCalendarComImpl implements IEventCalendarCom {

    @Override
    public Dictionary<String, Object> getAllEvent() {
        Document doc = null;
        Dictionary<String, Object> result = null;
        try {
            doc = Jsoup.connect(Constant.EventCalendarBaseUrl+"etkinlikler").get();
            Elements eventName = doc.select("div.views-field-field-etkinlik");


            result = new Hashtable<>();
            for (Element e : eventName) {

                String eventHrefUl = e.select("div.ozet-alani> a[href]").attr("href");
                result.put(e.text(), Constant.EventCalendarBaseUrl+eventHrefUl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}
