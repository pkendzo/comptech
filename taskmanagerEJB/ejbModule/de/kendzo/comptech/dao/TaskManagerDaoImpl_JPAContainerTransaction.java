package de.kendzo.comptech.dao;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * Session Bean implementation class TaskManagerDaoImpl_JPAContainerTransaction
 */
@Stateless(mappedName = "taskmanagerJPACT")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TaskManagerDaoImpl_JPAContainerTransaction implements TaskManagerDao_JPAContainerTransaction {

    /**
     * Default constructor. 
     */
    public TaskManagerDaoImpl_JPAContainerTransaction() {
        // TODO Auto-generated constructor stub
    }

}
