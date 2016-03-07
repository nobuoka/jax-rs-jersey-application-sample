package info.vividcode.web.app.jerseysample;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public class MyApplication extends Application {

    private static final String CONTROLLERS_PACKAGE_PREFIX = ".controllers";

    /*
    public MyApplication() {
        // Add a package used to scan for components.
        packages(this.getClass().getPackage().getName() + CONTROLLERS_PACKAGE_PREFIX);
    }
    */

}
