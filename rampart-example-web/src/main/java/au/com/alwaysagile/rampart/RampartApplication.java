package au.com.alwaysagile.rampart;

import au.com.alwaysagile.rampart.filter.RampartFilter;
import au.com.alwaysagile.rampart.resources.ExampleResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class RampartApplication extends Application<RampartConfiguration> {

    public static void main(final String[] args) throws Exception {
        new RampartApplication().run(args);
    }

    @Override
    public String getName() {
        return "rampart";
    }

    @Override
    public void initialize(final Bootstrap<RampartConfiguration> bootstrap) {
        bootstrap
                .addBundle(new ViewBundle<>());
    }

    @Override
    public void run(final RampartConfiguration configuration,
                    final Environment environment) {
        environment
                .servlets()
                .addFilter("rampartFilter", new RampartFilter())
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        environment
                .jersey()
                .register(new ExampleResource());
    }

}
