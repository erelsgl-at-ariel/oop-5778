package proxy;

import java.io.IOException;

/**
 * @author Pankaj, https://www.journaldev.com/1572/proxy-design-pattern
 */
public class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String cmd) throws IOException {
		Runtime.getRuntime().exec(cmd);
		System.out.println("'" + cmd + "' command executed.");
	}

}