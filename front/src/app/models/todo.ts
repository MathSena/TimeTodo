export interface Todo {
  /**
   * The unique identifier for the to-do item.
   * This may be optional if the item hasn't been saved to a database yet.
   */
  id?: string;

  /** The title or main content of the to-do item. */
  title: string;

  /** A detailed description or notes about the to-do item. */
  description?: string;

  /** The date and time by which the task should be completed. */
  timeToFinish: Date;

  /** A flag indicating whether the to-do item has been completed. */
  finished: boolean;
}
