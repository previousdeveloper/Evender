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
 * Created by previousdeveloper on 2.09.2015.
 */
public class IZorluCenterImpl implements IZorluCenter {
    @Override
    public Dictionary<String, Object> getAllEvent() {
        Document doc = null;
        Dictionary<String, Object> result = null;
        try {
            doc = Jsoup.connect(Constant.ZorluEventBaseUrl).get();
            Elements eventName = doc.select("div.eventCalendar");


            result = new Hashtable<>();
            for (Element e : eventName) {


                result.put(e.cssSelector(), new Object());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}
