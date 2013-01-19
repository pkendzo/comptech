package de.kendzo.comptech.dao;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Remote;

import org.hibernate.HibernateException;

import de.kendzo.comptech.domain.CategoryEntity;
import de.kendzo.comptech.domain.TaskEntity;

@Remote
public interface TaskManagerDao_HibernateBeanTransaction {

	/**
	 * This ejb uses hibernate and a bean persistence transactions management 
	 * to handle transactions
	 * 
	 * @param task
	 * @return
	 * @throws HibernateException
	 */
	public Serializable createTask(TaskEntity task) throws HibernateException;

	/**
	 * 
	 * @param category
	 * @return
	 * @throws HibernateException
	 */
	public Serializable createTaskCategory(CategoryEntity category)
			throws HibernateException;

	/**
	 * 
	 * @param taskID
	 * @throws HibernateException
	 */
	public void deleteTask(Long taskID) throws HibernateException;

	/**
	 * 
	 * @param categoryId
	 * @throws HibernateException
	 */
	public void deleteTaskCategory(Long categoryId) throws HibernateException;

	/**
	 * This method retrieves the to do Iterable of the actual day
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public Iterable<TaskEntity> retrieveActualTasks() throws HibernateException;

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public Iterable<CategoryEntity> retrieveAllTaskCategories()
			throws HibernateException;

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public Iterable<TaskEntity> retrieveAllTasks() throws HibernateException;

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public Iterable<TaskEntity> retrieveCompletedTasks()
			throws HibernateException;

	/**
	 * This method retrieves all scheduled tasks (for the future)
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public Iterable<TaskEntity> retrieveScheduledTasks()
			throws HibernateException;

	/**
	 * 
	 * @param taskId
	 * @return
	 * @throws HibernateException
	 */
	public Serializable retrieveTaskById(Long taskId) throws HibernateException;

	/**
	 * 
	 * @param categoryId
	 * @return
	 */
	CategoryEntity retrieveTaskCategoryById(Long categoryId)
			throws HibernateException;

	/**
	 * 
	 * @param date
	 * @return
	 * @throws HibernateException
	 */
	public Iterable<TaskEntity> retrieveTasksByDate(Date date)
			throws HibernateException;

	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public Iterable<TaskEntity> retrieveTomorrowTasks()
			throws HibernateException;

	/**
	 * 
	 * @param task
	 * @return
	 * @throws HibernateException
	 */
	public Serializable updateTask(TaskEntity task) throws HibernateException;

	/**
	 * 
	 * @param category
	 * @return
	 * @throws HibernateException
	 */
	public Serializable updateTaskCategory(CategoryEntity category)
			throws HibernateException;

}
