package de.kendzo.comptech.dao;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.ejb.HibernateEntityManager;

import de.kendzo.comptech.domain.CategoryEntity;
import de.kendzo.comptech.domain.TaskEntity;

/**
 * Session Bean implementation class
 * TaskManagerDaoImpl_HibernateContainerTransaction
 */
@Stateless(mappedName = "taskmanagerHibernateCT")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TaskManagerDaoImpl_HibernateContainerTransaction implements
		TaskManagerDao_HibernateContainerTransaction {

	@PersistenceContext(unitName = "taskmanager")
	private HibernateEntityManager em;

	/**
	 * Default constructor.
	 */
	public TaskManagerDaoImpl_HibernateContainerTransaction() {

	}

	@Override
	public Serializable createTask(TaskEntity task) throws HibernateException {

		//TaskEntity createdTask = (TaskEntity) em.getSession().save(task);
		Long createdTask = (Long) em.getSession().save(task);
		em.getSession().flush();

		return createdTask;
	}
	
	@Override
	public Serializable createTaskCategory(CategoryEntity category)
			throws HibernateException {
		
		//CategoryEntity createdTaskCat = (CategoryEntity) em.getSession().save(category);
		Long createdTaskCat = (Long) em.getSession().save(category);
		em.getSession().flush();
		
		return createdTaskCat;
	}
	
	@Override
	public void deleteTask(Long taskID) throws HibernateException {

		TaskEntity taskToDelete = (TaskEntity) retrieveTaskById(taskID);
		em.getSession().delete(taskToDelete);
		em.getSession().flush();
	}

	@Override
	public void deleteTaskCategory(Long categoryId)
			throws HibernateException {
		
		CategoryEntity catToDelete = (CategoryEntity) retrieveTaskCategoryById(categoryId);
		em.getSession().delete(catToDelete);
		em.getSession().flush();

	}

	@Override
	public Iterable<TaskEntity> retrieveActualTasks() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CategoryEntity> retrieveAllTaskCategories()
			throws HibernateException {
		 TypedQuery<CategoryEntity> query = em.createNamedQuery("retrieveAllTaskCategories", CategoryEntity.class);
		 Iterable<CategoryEntity> catList = query.getResultList();
		 
		return catList;
	}

	@Override
	public Iterable<TaskEntity> retrieveAllTasks() throws HibernateException {
		
		 TypedQuery<TaskEntity> query = em.createNamedQuery("retrieveAllTasks", TaskEntity.class);
		 Iterable<TaskEntity> entityList = query.getResultList();
		 
		return entityList;
	}

	@Override
	public Iterable<TaskEntity> retrieveCompletedTasks()
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<TaskEntity> retrieveScheduledTasks()
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable retrieveTaskById(Long taskId) throws HibernateException {
		
		TaskEntity task = (TaskEntity) em.getSession().get(
				TaskEntity.class, taskId);
		return task;
	}

	@Override
	public CategoryEntity retrieveTaskCategoryById(Long categoryId) throws HibernateException {
		
		CategoryEntity cat = (CategoryEntity) em.getSession().get(
				CategoryEntity.class, categoryId);
		return cat;
	}

	@Override
	public Iterable<TaskEntity> retrieveTasksByDate(Date date)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<TaskEntity> retrieveTomorrowTasks()
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable updateTask(TaskEntity task) throws HibernateException {

		TaskEntity mergedTask = (TaskEntity) em.getSession().merge(task);

		return mergedTask;
	}

	@Override
	public Serializable updateTaskCategory(CategoryEntity category)
			throws HibernateException {
		
		CategoryEntity mergedCat = (CategoryEntity) em.getSession().merge(category);

		return mergedCat;
	}

}
