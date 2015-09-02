package Interface;

import Model.EventModel;

import java.util.List;

/**
 * Created by previousdeveloper on 1.09.2015.
 */
public interface IEventComService {

    List<EventModel> getByCity(String city);
}
