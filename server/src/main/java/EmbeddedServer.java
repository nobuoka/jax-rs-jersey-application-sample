import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.jboss.weld.environment.servlet.BeanManagerResourceBindingListener;
import org.jboss.weld.environment.servlet.Listener;

public class EmbeddedServer {

    public static void main(String[] args) throws Exception {
        // 1. war ファイルの設定
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar("build/libs/app.war");

        // アノテーションなどを使えるように。
        // See: http://www.eclipse.org/jetty/documentation/current/using-annotations-embedded.html
        Server server = new Server(1234);
        //Enable parsing of jndi-related parts of web.xml and jetty-env.xml
        Configuration.ClassList classlist = Configuration.ClassList.setServerDefault(server);
        classlist.addAfter(org.eclipse.jetty.webapp.FragmentConfiguration.class.getCanonicalName(),
                org.eclipse.jetty.plus.webapp.EnvConfiguration.class.getCanonicalName(),
                org.eclipse.jetty.plus.webapp.PlusConfiguration.class.getCanonicalName()
        );
        classlist.addBefore(org.eclipse.jetty.webapp.JettyWebXmlConfiguration.class.getCanonicalName(),
                org.eclipse.jetty.annotations.AnnotationConfiguration.class.getCanonicalName()
        );
        Class<?> c;
        c = org.eclipse.jetty.webapp.WebInfConfiguration.class;
        c = org.eclipse.jetty.webapp.WebXmlConfiguration.class;
        c = org.eclipse.jetty.webapp.MetaInfConfiguration.class;
        c = org.eclipse.jetty.webapp.FragmentConfiguration.class;
        c = org.eclipse.jetty.plus.webapp.EnvConfiguration.class;
        c = org.eclipse.jetty.webapp.JettyWebXmlConfiguration.class;

        // CDI by Weld
        webapp.addEventListener(new BeanManagerResourceBindingListener());
        webapp.addEventListener(new Listener());

        /*
        // 2. @WebServlet とかを有効にしている
        Configuration[] configurations = {
                new AnnotationConfiguration(),
                new WebInfConfiguration(),
                new WebXmlConfiguration(),
                new MetaInfConfiguration(),
                new FragmentConfiguration(),
                new EnvConfiguration(),
                new PlusConfiguration(),
                new JettyWebXmlConfiguration(),
        };
        war.setConfigurations(configurations);
        */

        server.setHandler(webapp);


        //Register new transaction manager in JNDI
        //At runtime, the webapp accesses this as java:comp/UserTransaction
        //org.eclipse.jetty.plus.jndi.Transaction transactionMgr = new org.eclipse.jetty.plus.jndi.Transaction(new com.acme.MockUserTransaction());

        //Define an env entry with webapp scope.
        //org.eclipse.jetty.plus.jndi.EnvEntry maxAmount = new org.eclipse.jetty.plus.jndi.EnvEntry (webapp, "maxAmount", new Double(100), true);


        // Register a  mock DataSource scoped to the webapp
        //org.eclipse.jetty.plus.jndi.Resource mydatasource = new org.eclipse.jetty.plus.jndi.Resource(webapp, "jdbc/mydatasource", new com.acme.MockDataSource());

        server.start();
        server.join();
    }

}
