package au.com.alwaysagile.rampart.views;

import io.dropwizard.views.View;

public class ExampleView extends View {

    private final String name;

    public ExampleView(String name) {
        super("/example.mustache");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
