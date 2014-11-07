package service;

import java.util.List;

import models.Task;

/**
 * 
 * @author ANish NAth
 *
 */
public interface ITask {
	
	/**
	 * Save the task
	 * @param task
	 */
	public void create(String task);
	
	/**
	 * delete the task
	 */
	public  void delete(Long id);
	
	/**
	 * 
	 * @return List of Tasks
	 */
	public  List<Task> listAllTask();

}
