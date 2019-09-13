 /* @author arnav
 * @version 1.0
 */
public class SimpleTimer
{
    private long lastMark = System.currentTimeMillis();
    
    /**
     */
    public void mark()
    {
        lastMark = System.currentTimeMillis();
    }
    
    /**
     */
    public int elapse()
    {
        return (int) (System.currentTimeMillis() - lastMark);
    }
}