package info.vividcode.web.app.jerseysample;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class MyApplication extends Application {

    //private static final String CONTROLLERS_PACKAGE_PREFIX = ".controllers";

    /*
    public MyApplication() {
        // Add a package used to scan for components.
        //packages(this.getClass().getPackage().getText() + CONTROLLERS_PACKAGE_PREFIX);
    }
    */

}
