package service;

import java.util.List;

import models.Task;

/**
 * 
 * @author Anish Nath
 *
 */

public interface DataServices {

	/**
	 * Save the task
	 * 
	 * @param task
	 */
	public boolean create(String task) throws Exception;

	/**
	 * delete the task
	 */
	public boolean delete(Long id)  throws Exception;

	/**
	 * 
	 * @return List of Tasks
	 */
	public List<Task> listAllTask()  throws Exception;
	
	/**
	 * 
	 * @return Get a task Based on id
	 */
	public Task getTask(Long id)  throws Exception;
	


}
