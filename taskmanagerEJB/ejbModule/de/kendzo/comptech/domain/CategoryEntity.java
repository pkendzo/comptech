/**
 * 
 */
package de.kendzo.comptech.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.Hibernate;

/**
 * @author PatrickPierre
 *
 */

@NamedQueries({ @NamedQuery(name = "retrieveAllTaskCategories", query = "select c from CategoryEntity c order by c.categoryName asc") })
@Entity
@Table(name = "TASK_CATEGORY")
public class CategoryEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3503230212899178680L;

	/*
	 * 
	 */
	private Long categoryID;
	
	/**
	 * 
	 */
	private String categoryName;
	
	
	public CategoryEntity(){
		super();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (Hibernate.getClass(this) != Hibernate.getClass(obj))
			return false;
		CategoryEntity other = (CategoryEntity) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		return true;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CATEGORYID")
	public Long getCategoryID() {
		return categoryID;
	}


	@Column(name = "CATEGORY_NAME", nullable = false)
	public String getCategoryName() {
		return categoryName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryName == null) ? 0 : categoryName.hashCode());
		return result;
	}


	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("CategoryEntity [categoryID=%s, categoryName=%s]",
				categoryID, categoryName);
	}
	
}
