package dao;

import java.util.List;

import models.Task;

public interface DataDao {

	boolean addEntity(Task task) throws Exception;

	Task getEntityById(long id) throws Exception;

	List<Task> getEntityList() throws Exception;

	boolean deleteEntity(long id) throws Exception;

}
