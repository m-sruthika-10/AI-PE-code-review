/**
 * Manages a todo list with basic operations like adding and removing tasks.
 * @module TodoList
 */

/**
 * Represents a single todo item.
 * @typedef {Object} TodoItem
 * @property {string} id - Unique identifier for the todo item
 * @property {string} description - Description of the task
 * @property {boolean} isCompleted - Completion status
 */

/**
 * Manages the todo list operations.
 */
class TodoList {
  #todos;

  /**
   * Initializes an empty todo list.
   */
  constructor() {
    this.#todos = [];
  }

  /**
   * Adds a new todo item to the list.
   * @param {string} description - The task description
   * @returns {TodoItem} The newly created todo item
   * @throws {Error} If description is invalid
   */
  addTodo(description) {
    if (!description || typeof description !== 'string' || description.trim() === '') {
      throw new Error('Description must be a non-empty string');
    }

    const todo = {
      id: crypto.randomUUID(),
      description: description.trim(),
      isCompleted: false,
    };

    this.#todos.push(todo);
    return todo;
  }

  /**
   * Removes a todo item by its ID.
   * @param {string} id - The ID of the todo item to remove
   * @returns {boolean} True if the item was removed, false if not found
   */
  removeTodo(id) {
    const index = this.#todos.findIndex((todo) => todo.id === id);
    if (index === -1) {
      return false;
    }
    this.#todos.splice(index, 1);
    return true;
  }

  /**
   * Gets all todo items.
   * @returns {TodoItem[]} Array of all todo items
   */
  getTodos() {
    return [...this.#todos];
  }

  /**
   * Toggles the completion status of a todo item.
   * @param {string} id - The ID of the todo item
   * @returns {boolean} True if the status was toggled, false if not found
   */
  toggleTodo(id) {
    const todo = this.#todos.find((todo) => todo.id === id);
    if (!todo) {
      return false;
    }
    todo.isCompleted = !todo.isCompleted;
    return true;
  }
}

export default TodoList;
