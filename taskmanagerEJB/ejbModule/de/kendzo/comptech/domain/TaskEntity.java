package de.kendzo.comptech.domain;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.Hibernate;

/**
 * Entity implementation class for Entity: TaskEntity (JPA and Hibernate)
 * 
 */

@NamedQueries({ @NamedQuery(name = "retrieveAllTasks", query = "select t from TaskEntity t order by t.creationDate desc") })
@Entity
@Table(name = "TASKS")
public class TaskEntity implements Serializable {

	/**
	 * 
	 */
	private Long taskID;

	/**
	 * 
	 */
	private String taskName;

	/**
	 * 
	 */
	private Date startDate;

	/**
	 * 
	 */
	private Date dueDate;

	/**
	 * 
	 */
	private Date completeDate;

	/**
	 * 
	 */
	private Date creationDate;

	/**
	 * 
	 */
	private TaskState dueState;

	/**
	 * 
	 */
	private TaskPriority priority;

	/**
	 * 
	 */
	private TaskCompleteDegree completeDegree;

	/**
	 * Check if a task is either complete or not
	 */
	private Boolean done;

	/**
	 * 
	 */
	private String location;

	/**
	 * 
	 */
	private String note;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Collection<CategoryEntity> categoryList;

	public TaskEntity() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj))
			return false;
		if (!(obj instanceof TaskEntity))
			return false;
		TaskEntity other = (TaskEntity) obj;
		if (completeDegree != other.completeDegree)
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (done == null) {
			if (other.done != null)
				return false;
		} else if (!done.equals(other.done))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (dueState != other.dueState)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (taskName == null) {
			if (other.taskName != null)
				return false;
		} else if (!taskName.equals(other.taskName))
			return false;
		return true;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@OrderBy("categoryName asc")
	@JoinTable(name = "TASK_CATEGORY_ENTITY", joinColumns = { @JoinColumn(name = "TASK_FK") }, inverseJoinColumns = { @JoinColumn(name = "CATEGORY_FK") })
	public Collection<CategoryEntity> getCategoryList() {
		return categoryList;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "COMPLETEDATE")
	public Date getCompleteDate() {
		return this.completeDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "COMPLETE_DEGREE")
	public TaskCompleteDegree getCompleteDegree() {
		return this.completeDegree;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATIONDATE", nullable = false)
	public Date getCreationDate() {
		return creationDate;
	}

	@Column(name = "DONE", nullable = false)
	public Boolean getDone() {
		return done;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DUEDATE")
	public Date getDueDate() {
		return this.dueDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TASK_STATE", nullable = false)
	public TaskState getDueState() {
		return this.dueState;
	}

	@Column(name = "LOCATION")
	public String getLocation() {
		return this.location;
	}

	@Column(name = "NOTE", columnDefinition = "TEXT")
	public String getNote() {
		return this.note;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TASK_PRIORITY", nullable = false)
	public TaskPriority getPriority() {
		return this.priority;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", nullable = false)
	public Date getStartDate() {
		return this.startDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TASKID")
	public Long getTaskID() {
		return this.taskID;
	}

	@Column(name = "TASK_NAME", nullable = false)
	public String getTaskName() {
		return this.taskName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((completeDegree == null) ? 0 : completeDegree.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((done == null) ? 0 : done.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result
				+ ((dueState == null) ? 0 : dueState.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((taskName == null) ? 0 : taskName.hashCode());
		return result;
	}

	public void setCategoryList(Collection<CategoryEntity> categoryList) {
		this.categoryList = categoryList;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public void setCompleteDegree(TaskCompleteDegree completeDegree) {
		this.completeDegree = completeDegree;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setDueState(TaskState dueState) {
		this.dueState = dueState;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setTaskID(Long taskID) {
		this.taskID = taskID;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TaskEntity [taskID=" + taskID + ", taskName=" + taskName
				+ ", startDate=" + startDate + ", dueDate=" + dueDate
				+ ", completeDate=" + completeDate + ", creationDate="
				+ creationDate + ", dueState=" + dueState + ", priority="
				+ priority + ", completeDegree=" + completeDegree + ", done="
				+ done + ", categoryList=" + categoryList + "]";
	}

}
