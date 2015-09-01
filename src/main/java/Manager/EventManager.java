package Manager;

import Service.IEventCalendarCom;

import java.util.Dictionary;

/**
 * Created by previousdeveloper on 2.09.2015.
 */
public class EventManager implements IEventManager{

    private IEventCalendarCom _eventCalendarCom;

    public EventManager(IEventCalendarCom eventCalendarCom) {

        this._eventCalendarCom = eventCalendarCom;
    }

    public Dictionary<String, Object> ss() {

        return _eventCalendarCom.getAllEvent();
    }
}
