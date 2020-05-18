package lt.vu.decorators;

import lt.vu.services.DateTimeService;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class MainNewFeedDecorator implements NewsFeed{
    @Inject
    @Delegate
    @Any
    MainNewsFeed newsFeed;

    @Inject
    private DateTimeService dateTimeService;

    @Override
    public String welcome() {
        String news = newsFeed.welcome();
        return news + dateTimeService.date();
    }

}
