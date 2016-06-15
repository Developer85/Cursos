
package tutoriallog4j;
import org.apache.log4j.Logger;

/**
 *
 * @author usu21
 */

public class HelloExample
{
    private final Logger logger;
    
    public HelloExample()
    {
        logger = Logger.getLogger(HelloExample.class);
    }

    public void runMe(String parameter)
    {		
        if(logger.isDebugEnabled()){
                logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
                logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);
    }
    
    public void segundoMetodo()
    {
        if(logger.isInfoEnabled())
        {
            logger.info("Debug desde el método 2 ");
        }
    }
}
