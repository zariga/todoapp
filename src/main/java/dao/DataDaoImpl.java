package dao;

import java.util.List;

import models.Task;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addEntity(Task task) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(task);
		tx.commit();
		session.close();

		return false;
	}

	public Task getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Task task = (Task) session.get(Task.class, new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return task;
	}

	@SuppressWarnings("unchecked")
	public List<Task> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Task> employeeList = session.createCriteria(Task.class).list();
		tx.commit();
		session.close();
		return employeeList;
	}

	public boolean deleteEntity(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Task.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
