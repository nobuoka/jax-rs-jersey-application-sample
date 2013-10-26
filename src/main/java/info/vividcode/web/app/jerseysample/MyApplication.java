package info.vividcode.web.app.jerseysample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import info.vividcode.web.app.jerseysample.controllers.Root;

@ApplicationPath("/")
public class MyApplication extends Application {

    private static final Set<Class<?>> CLASSES =
            new HashSet<Class<?>>(Arrays.asList(Root.class));

    @Override
    public Set<Class<?>> getClasses() {
        return CLASSES;
    }

}
