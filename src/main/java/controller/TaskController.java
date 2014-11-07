
package controller;

import java.util.List;

import models.Status;
import models.Task;

import org.apache.log4j.Logger;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.DataServices;

/**
 * 
 * @author Anish Nath
 *
 */

@Controller
@RequestMapping("/todo")
public class TaskController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(TaskController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addTask(@RequestBody String task) {
		try {
			dataServices.create(task);
			return new Status(1, "Task added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Task getTask(@PathVariable("id") long id) {
		Task task = null;
		try {
			task = dataServices.getTask(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Task> getTasks() {

		List<Task> employeeList = null;
		try {
			employeeList = dataServices.listAllTask();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteEmployee(@PathVariable("id") long id) {

		try {
			dataServices.delete(id);
			return new Status(1, "TODO task deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
