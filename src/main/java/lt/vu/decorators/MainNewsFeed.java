package lt.vu.decorators;

import javax.enterprise.inject.Default;

@Default
public class MainNewsFeed implements NewsFeed{

    @Override
    public String welcome() {
        return "Kindergarten main page.  ";
    }
}
