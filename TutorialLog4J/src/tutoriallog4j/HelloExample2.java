
package tutoriallog4j;
import org.apache.log4j.Logger;

/**
 *
 * @author usu21
 */

public class HelloExample2
{
    private final Logger logger;
    
    public HelloExample2()
    {
        logger = Logger.getLogger(HelloExample2.class);
    }

    public void divide()
    {
        try
        {
            int i = 10 / 0;
        }
        catch (ArithmeticException ex)
        {
            logger.error("Se ha producido un error.", ex);
        }
    }
}
