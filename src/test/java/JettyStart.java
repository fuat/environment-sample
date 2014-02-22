import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author Fuat Atabey
 */
public class JettyStart {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
//        context.setContextPath("");
        //these should be safe defaults in commerce - if not we can still expose them in the config class
        context.setResourceBase("src/main/webapp/");
        context.setDescriptor("src/main/webapp/WEB-INF/web.xml");
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
