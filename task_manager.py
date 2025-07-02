#!/usr/bin/env python3
"""A simple task manager to add, view, and complete tasks."""

class TaskManager:
    """Class to manage a list of tasks."""
    
    def __init__(self):
        """Initialize an empty task list."""
        self.tasks = []

    def add_task(self, task_name: str) -> None:
        """Add a new task to the list."""
        if task_name.strip():
            self.tasks.append({"name": task_name, "completed": False})
            print(f"Task '{task_name}' added successfully.")
        else:
            print("Error: Task name cannot be empty.")

    def view_tasks(self) -> None:
        """Display all tasks with their status."""
        if not self.tasks:
            print("No tasks available.")
            return
        print("\nTasks:")
        for index, task in enumerate(self.tasks, 1):
            status = "✓" if task["completed"] else " "
            print(f"{index}. [{status}] {task['name']}")

    def complete_task(self, task_index: int) -> None:
        """Mark a task as completed by index."""
        if 1 <= task_index <= len(self.tasks):
            self.tasks[task_index - 1]["completed"] = True
            print(f"Task '{self.tasks[task_index - 1]['name']}' marked as completed.")
        else:
            print("Error: Invalid task index.")

def main():
    """Main function to run the task manager."""
    manager = TaskManager()
    manager.add_task("Buy groceries")
    manager.add_task("Finish homework")
    manager.view_tasks()
    manager.complete_task(1)
    manager.view_tasks()

if __name__ == "__main__":
    main()
