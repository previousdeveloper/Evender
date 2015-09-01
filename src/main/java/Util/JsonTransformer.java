package Util;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by previousdeveloper on 1.09.2015.
 */
public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}