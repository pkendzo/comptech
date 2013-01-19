package de.kendzo.comptech.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * Session Bean implementation class TaskManagerDaoImpl_JPABeanTransaction
 */
@Stateless(mappedName = "taskmanagerJPABT")
@TransactionManagement(TransactionManagementType.BEAN)
public class TaskManagerDaoImpl_JPABeanTransaction implements TaskManagerDao_JPABeanTransaction {

    /**
     * Default constructor. 
     */
    public TaskManagerDaoImpl_JPABeanTransaction() {
        // TODO Auto-generated constructor stub
    }

}
