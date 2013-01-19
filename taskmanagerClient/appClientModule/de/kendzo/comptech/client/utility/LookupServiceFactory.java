/**
 * 
 */
package de.kendzo.comptech.client.utility;

import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

import de.kendzo.comptech.service.TaskManagerService;
import de.kendzo.comptech.service.TaskManagerServiceImpl;

/**
 * @author PatrickPierre
 * 
 */
public class LookupServiceFactory {

	private static Logger logger = Logger.getLogger(LookupServiceFactory.class);

	public static TaskManagerService doLookupTaskManagerService() {
		Context context = null;
		TaskManagerService bean = null;
		try {
			// 1. Obtaining Context
			context = JNDILookupClass.getInitialContext();
			// 2. Generate JNDI Lookup name
			String lookupName = getLookupTaskmanagerServiceName();
			// 3. Lookup and cast
			bean = (TaskManagerService) context.lookup(lookupName);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

	private static String getLookupTaskmanagerServiceName() {

		/*
		 * The app name is the EAR name of the deployed EJB without .ear suffix.
		 * Since we haven't deployed the application as a .ear, the app name for
		 * us will be an empty string
		 */
		String appName = "taskmanager";

		/*
		 * The module name is the JAR name of the deployed EJB without the .jar
		 * suffix.
		 */
		String moduleName = "taskmanagerEJB";

		/*
		 * AS7 allows each deployment to have an (optional) distinct name. This
		 * can be an empty string if distinct name is not specified.
		 */
		String distinctName = "";

		// The EJB bean implementation class name
		String beanName = TaskManagerServiceImpl.class.getSimpleName();

		// Fully qualified remote interface name
		final String interfaceName = TaskManagerService.class.getName();

		// Create a look up string name
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName
				+ "/" + beanName + "!" + interfaceName;
		logger.info("Name des Services::" + name);
		return name;
	}

}
