package lt.vu.usecases;

import lt.vu.decorators.NewsFeed;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class NewsFeedInformation {
    @Inject
    private NewsFeed newsFeed;

    public String welcome() {
        return newsFeed.welcome();
    }
}
