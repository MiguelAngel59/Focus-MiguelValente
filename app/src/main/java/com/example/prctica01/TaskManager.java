package com.example.prctica01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * TaskManager is responsible for managing a collection of suggested tasks.
 */
public class TaskManager {

    private List<Task> tasks;

    private int nextId;

    public enum Status {
        NOT_STARTED, IN_PROGRESS, COMPLETED
    }

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Adds a new task with default status (NOT_STARTED) and no deadline.
     *
     * @param title       task title
     * @param description task description
     */
    public void addTask(String title, String description) {
        Task newTask = new Task(nextId++, title, description, Status.NOT_STARTED, null);
        tasks.add(newTask);
    }

    /**
     * Adds a new task with a deadline. Status is initialized as NOT_STARTED.
     *
     * @param title       task title
     * @param description task description
     * @param deadline    task deadline
     */
    public void addTask(String title, String description, LocalDate deadline) {
        Task newTask = new Task(nextId++, title, description, Status.NOT_STARTED, deadline);
        tasks.add(newTask);
    }

    /**
     * Adds a new task specifying all attributes.
     *
     * @param title       task title
     * @param description task description
     * @param status      initial task status
     * @param deadline    task deadline
     */
    public void addTask(String title, String description, Status status, LocalDate deadline) {
        Task newTask = new Task(nextId++, title, description, status, deadline);
        tasks.add(newTask);
    }

    /**
     * Displays all registered tasks. If no tasks exist, a message is shown.
     */
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks added.");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    /**
     * Searches for a task by its id.
     *
     * @param id			 task identifier
     * @return the Task if found, otherwise null
     */
    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    /**
     * Updates the information of a task.
     *
     * @param id             task identifier
     * @param newTitle       updated title
     * @param newDescription updated description
     * @param newDeadline    updated deadline
     * @return true if the task was updated, false otherwise
     */
    public boolean updateTask(int id, String newTitle, String newDescription, LocalDate newDeadline) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setTitle(newTitle);
            task.setDescription(newDescription);
            task.setDeadline(newDeadline);
            return true;
        }
        return false;
    }

    /**
     * Updates the status of a task.
     *
     * @param id			 task identifier
     * @param newStatus 	 new status to assign
     * @return true if the status was updated, false if the task was not found
     */
    public boolean updateTaskStatus(int id, Status newStatus) {
        Task task = getTaskById(id);
        if (task == null) {
            return false;
        }
        task.setStatus(newStatus);
        return true;
    }

    /**
     * Changes the task status to IN_PROGRESS. Only allowed if the task is currently
     * NOT_STARTED.
     *
     * @param id 			 task identifier
     * @return true if status changed, false otherwise
     */
    public boolean startTask(int id) {
        Task task = getTaskById(id);
        if (task != null && task.getStatus() == Status.NOT_STARTED) {
            task.setStatus(Status.IN_PROGRESS);
            return true;
        }
        return false;
    }

    /**
     * Changes the task status to COMPLETED.
     *
     * @param id		     task identifier
     * @return true if status changed, false otherwise
     */
    public boolean completeTask(int id) {
        Task task = getTaskById(id);
        if (task != null && task.getStatus() != Status.COMPLETED) {
            task.setStatus(Status.COMPLETED);
            return true;
        }
        return false;
    }

    /**
     * Removes a task from the list.
     *
     * @param id 			 task identifier
     * @return true if removed, false if not found
     */
    public boolean deleteTask(int id) {
        Task task = getTaskById(id);
        if (task != null) {
            tasks.remove(task);
            return true;
        }
        return false;
    }

    /**
     * Removes a all task from list.
     */
    public void deleteAllTasks() {
        if (tasks.isEmpty()) {
            return;
        }
        tasks.clear();
    }



    /**
     * Represents a single task entity.
     */
    private class Task {

        private int id;
        private String title;
        private String description;
        private Status status;
        private LocalDate deadline;

        public Task(int id, String title, String description, Status status, LocalDate deadline) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.status = status;
            this.deadline = deadline;
        }

        public int getId() {
            return id;
        }

        public Status getStatus() {
            return status;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public void setDeadline(LocalDate deadline) {
            this.deadline = deadline;
        }

        @Override
        public String toString() {
            return "ID: " + id + " , Title: " + title + " , Description: " + description + " , Status: " + status
                    + " , Deadline: " + (deadline != null ? deadline : "No deadline");
        }
    }
}