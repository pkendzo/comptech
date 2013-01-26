package de.kendzo.comptech.service;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import de.kendzo.comptech.dao.TaskManagerDao_HibernateContainerTransaction;
import de.kendzo.comptech.domain.CategoryEntity;
import de.kendzo.comptech.domain.TaskEntity;

/**
 * Session Bean implementation class TaskManagerServiceImpl
 */
@WebService
@Stateless(mappedName = "taskmanagerService")
public class TaskManagerServiceImpl implements TaskManagerService {

	@EJB
	private TaskManagerDao_HibernateContainerTransaction dao;
	
	/*
	@EJB
	private TaskManagerDao_HibernateBeanTransaction daoBean;
	*/
	
	/*
	 * @EJB
	 * private TaskManagerDao_JPABeanTransaction daoBean
	 */
	
	/*
	 * @EJB
	 * private TaskManagerDao_JPAContainerTransaction daoBean
	 */
	
	 private static Logger logger = Logger.getLogger
             (TaskManagerServiceImpl.class);
	 
	/**
	 * Default constructor.
	 */
	public TaskManagerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Serializable createNewTask(TaskEntity newTask)
			throws HibernateException {

		logger.info("Creating A TASK");
		return dao.createTask(newTask);
	}

	@Override
	public Serializable createNewTaskCategory(CategoryEntity newCategory)
			throws HibernateException {

		logger.info("Creating A CATEGORY");
		return dao.createTaskCategory(newCategory);
	}

	@Override
	public void deleteTaskCategoryWithId(Long categoryId)
			throws HibernateException {
		dao.deleteTaskCategory(categoryId);
		logger.info("CATEGORY "+categoryId+" deleted");
	}

	@Override
	public void deleteTaskWithId(Long taskID) throws HibernateException {
		
		dao.deleteTask(taskID);
		logger.info("TASK "+taskID+" deleted");
	}

	@Override
	public Serializable updateCategory(CategoryEntity cat)
			throws HibernateException {

		return dao.updateTaskCategory(cat);
	}

	@Override
	public Serializable updateTask(TaskEntity task) throws HibernateException {

		return dao.updateTask(task);
	}

	@Override
	public Iterable<CategoryEntity> retrieveAllTaskCategories() {
		
		return dao.retrieveAllTaskCategories();
	}

	@Override
	public Iterable<TaskEntity> retrieveAllTasks() throws HibernateException {
		
		return dao.retrieveAllTasks();
	}

	@Override
	public CategoryEntity retrieveTaskCategoryById(Long categoryId)
			throws HibernateException {
		
		return dao.retrieveTaskCategoryById(categoryId);
	}

}
