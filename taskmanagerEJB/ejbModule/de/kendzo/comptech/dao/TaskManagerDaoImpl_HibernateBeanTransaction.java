package de.kendzo.comptech.dao;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.ejb.HibernateEntityManager;

import de.kendzo.comptech.domain.CategoryEntity;
import de.kendzo.comptech.domain.TaskEntity;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class TaskManagerDaoImpl_HibernateBeanTransaction
 */
@Stateless(mappedName = "taskmanagerHibernateBT")
@TransactionManagement(TransactionManagementType.BEAN)
public class TaskManagerDaoImpl_HibernateBeanTransaction implements
		TaskManagerDao_HibernateBeanTransaction {

	@PersistenceContext(unitName = "taskmanager")
	private HibernateEntityManager em;

	private Session session;

	private Transaction transaction;

	/**
	 * Default constructor.
	 */
	public TaskManagerDaoImpl_HibernateBeanTransaction() {

	}

	@Override
	public Serializable createTask(TaskEntity task) throws HibernateException {

		this.startSession();
		TaskEntity createdTask = (TaskEntity) session.save(task);
		this.endSession();

		return createdTask;
	}

	@Override
	public Serializable createTaskCategory(CategoryEntity category)
			throws HibernateException {

		this.startSession();
		CategoryEntity createdCat = (CategoryEntity) session.save(category);
		this.endSession();

		return createdCat;
	}

	@Override
	public void deleteTask(Long taskID) throws HibernateException {

		this.startSession();
		TaskEntity taskToDelete = (TaskEntity) this.retrieveTaskById(taskID);
		session.delete(taskToDelete);
		this.endSession();
	}

	@Override
	public void deleteTaskCategory(Long categoryId) throws HibernateException {
		
		this.startSession();
		CategoryEntity catToDelete = (CategoryEntity) this.retrieveTaskCategoryById(categoryId);
		session.delete(catToDelete);
		this.endSession();
	}

	private void endSession() {
		transaction.commit();
		session.close();
	}

	@Override
	public Iterable<TaskEntity> retrieveActualTasks() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<CategoryEntity> retrieveAllTaskCategories()
			throws HibernateException {
		
		this.startSession();
		Query query = session
				.createQuery("select c from TaskEntity c order by c.categoryName asc");
		Iterable<CategoryEntity> catList = query.list();
		this.endSession();

		return catList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<TaskEntity> retrieveAllTasks() throws HibernateException {

		this.startSession();
		Query query = session
				.createQuery("select t from TaskEntity t order by t.creationDate desc");
		Iterable<TaskEntity> entityList = query.list();
		this.endSession();

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

		this.startSession();
		TaskEntity task = (TaskEntity) session.get(TaskEntity.class, taskId);
		this.endSession();

		return task;
	}

	@Override
	public CategoryEntity retrieveTaskCategoryById(Long categoryId)
			throws HibernateException {
		this.startSession();
		CategoryEntity cat = (CategoryEntity) session.get(CategoryEntity.class, categoryId);
		this.endSession();
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

	private void startSession() {
		session = em.getSession();
		session.setFlushMode(FlushMode.AUTO);
		transaction = session.beginTransaction();
	}

	@Override
	public Serializable updateTask(TaskEntity task) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable updateTaskCategory(CategoryEntity category)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}
