package DI;

import Interface.IEventCalendarComService;
import Interface.IEventComService;
import Interface.IZorluCenterService;
import Service.EventCalendarComServiceImpl;
import Service.EventComServiceImpl;
import Service.ZorluCenterServiceImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

/**
 * Created by previousdeveloper on 2.09.2015.
 */
public class Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(IEventComService.class).to(EventComServiceImpl.class).in(Singleton.class);
        bind(IEventCalendarComService.class).to(EventCalendarComServiceImpl.class).in(Singleton.class);
        bind(IZorluCenterService.class).to(ZorluCenterServiceImpl.class).in(Singleton.class);

    }
}