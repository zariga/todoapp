package service;

import java.util.List;

import models.Task;

import org.springframework.beans.factory.annotation.Autowired;

import dao.DataDao;

/**
 * 
 * @author ANish Nath
 * 
 */
public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;

	public boolean create(String task) throws Exception {
		Task task2 = new Task(task);
		return dataDao.addEntity(task2);
	}

	public boolean delete(Long id) throws Exception {
		return dataDao.deleteEntity(id);

	}

	public Task getTask(Long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	public List<Task> listAllTask() throws Exception {
		return dataDao.getEntityList();
	}

}
