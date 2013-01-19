package de.kendzo.comptech.service;

import java.io.Serializable;

import javax.ejb.Remote;

import org.hibernate.HibernateException;

import de.kendzo.comptech.domain.CategoryEntity;
import de.kendzo.comptech.domain.TaskEntity;

@Remote
public interface TaskManagerService {

	/**
	 * 
	 * @param newTask
	 * @return
	 * @throws HibernateException
	 */
	public Serializable createNewTask(TaskEntity newTask) throws HibernateException;
	
	/**
	 * 
	 * @param newCategory
	 * @return
	 * @throws HibernateException
	 */
	public Serializable createNewTaskCategory(CategoryEntity newCategory)
			throws HibernateException;
	
	/**
	 * 
	 * @param taskID
	 * @throws HibernateException
	 */
	public void deleteTaskWithId(Long taskID) throws HibernateException;
	
	/**
	 * 
	 * @param categoryId
	 * @throws HibernateException
	 */
	public void deleteTaskCategoryWithId(Long categoryId) throws HibernateException;
	
	/**
	 * 
	 * @param task
	 * @return
	 * @throws HibernateException
	 */
	public Serializable updateTask(TaskEntity task) throws HibernateException;
	
	/**
	 * 
	 * @param cat
	 * @return
	 * @throws HibernateException
	 */
	public Serializable updateCategory(CategoryEntity cat) throws HibernateException;
	
	/**
	 * 
	 * @return
	 */
	public Iterable<CategoryEntity> retrieveAllTaskCategories();
	
	
	/**
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public Iterable<TaskEntity> retrieveAllTasks() throws HibernateException;
	
	
	/**
	 * 
	 * @param categoryId
	 * @return
	 * @throws HibernateException
	 */
	public CategoryEntity retrieveTaskCategoryById(Long categoryId) throws HibernateException;
	
	
}
