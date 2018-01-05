package proxy;

/**
 * @author Pankaj, https://www.journaldev.com/1572/proxy-design-pattern
 */
public interface CommandExecutor {
	public void runCommand(String cmd) throws Exception;
}