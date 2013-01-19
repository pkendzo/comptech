/**
 * 
 */
package de.kendzo.comptech.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import de.kendzo.comptech.client.utility.LookupServiceFactory;
import de.kendzo.comptech.domain.CategoryEntity;
import de.kendzo.comptech.domain.TaskEntity;
import de.kendzo.comptech.domain.TaskPriority;
import de.kendzo.comptech.domain.TaskState;
import de.kendzo.comptech.service.TaskManagerService;

/**
 * @author PatrickPierre
 * 
 */
public class TaskmanagerClient {

	private static Logger logger = Logger.getLogger
            (TaskmanagerClient.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TaskManagerService service = LookupServiceFactory
				.doLookupTaskManagerService();

		
		try {
			
			// Create a task categories
			
			CategoryEntity cat = new CategoryEntity();
			cat.setCategoryName("First Category");
			service.createNewTaskCategory(cat);
			
			CategoryEntity cat2 = new CategoryEntity();
			cat2.setCategoryName("Second Category");
			Long cat2Id = (Long) service.createNewTaskCategory(cat2);
			
			
			// Create tasks
			
			TaskEntity task1 = new TaskEntity();
			task1.setTaskName("Task1");
			task1.setCreationDate(new GregorianCalendar().getTime());
			task1.setDone(false);
			task1.setDueState(TaskState.OPEN);
			task1.setStartDate(new GregorianCalendar().getTime());
			task1.setPriority(TaskPriority.NIEDRIG);
			service.createNewTask(task1);
			
			TaskEntity task2 = new TaskEntity();
			task2.setTaskName("Task2");
			task2.setCreationDate(new GregorianCalendar().getTime());
			task2.setDone(false);
			task2.setDueState(TaskState.OPEN);
			task2.setStartDate(new GregorianCalendar().getTime());
			task2.setPriority(TaskPriority.HOCH);
			service.createNewTask(task2);
			
			// Create a task with a category
			
			TaskEntity task3 = new TaskEntity();
			task3.setTaskName("Task3");
			task3.setCreationDate(new GregorianCalendar().getTime());
			task3.setDone(false);
			task3.setDueState(TaskState.OPEN);
			task3.setStartDate(new GregorianCalendar().getTime());
			task3.setPriority(TaskPriority.NIEDRIG);
			
			Collection<CategoryEntity> cats = new ArrayList<CategoryEntity>();
			// Retrieve a category
			CategoryEntity cat2Retrieved = service.retrieveTaskCategoryById(cat2Id);
			cats.add(cat2Retrieved);
			
			task3.setCategoryList(cats);
			service.createNewTask(task3);
			
			// Retrieve all categories
			Iterable<CategoryEntity> catList = service.retrieveAllTaskCategories();
			Iterator<CategoryEntity> iter = catList.iterator();
			
			while(iter.hasNext()){
				CategoryEntity tmp = iter.next();
				//logger.info("["+tmp.getCategoryID()+"::"+tmp.getCategoryName()+"]");
				logger.info(tmp.toString());
			}
			
			// Retrieve all tasks
			Iterable<TaskEntity> taskList = service.retrieveAllTasks();
			Iterator<TaskEntity> iter2 = taskList.iterator();
			
			while(iter.hasNext()){
				TaskEntity tmp = iter2.next();
				//logger.info("["+tmp.getTaskID()+"::"+tmp.getTaskName()+"]");
				logger.info(tmp.toString());
			}
			
			// Delete a task
			//service.deleteTaskCategoryWithId(new Long(4));
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		}

	}

}
