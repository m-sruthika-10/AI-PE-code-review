#!/usr/bin/env python3
class taskMgr: # Non-standard class name (should use CamelCase)
  def __init__(self):
      self.task_list=[] # No space around =, unclear name
  def addTask(self,taskName): # No space after comma, mixed case naming
      if taskName.strip():
          self.task_list.append({"n":taskName,"c":False}) # Inconsistent indentation, no spaces
          print(f"Task '{taskName}' added successfully.")
      else:
          print("Error: Task name cannot be empty.")
  def viewTasks(self): # Missing docstring
      if not self.task_list:
          print("No tasks available.")
          return
      print("\nTasks:")
      for i,t in enumerate(self.task_list,1): # No space after commas
          s="✓"if t["c"]else" " # No spaces around operators
          print(f"{i}. [{s}] {t['n']}") # Inconsistent quote usage
  def complete_task(self,task_idx): # Non-standard parameter name
      if 1<=task_idx<=len(self.task_list): # No spaces around comparison operators
          self.task_list[task_idx-1]["c"]=True # No spaces around =
          print(f"Task '{self.task_list[task_idx-1]['n']}' marked as completed.") # Line > 79 chars
      else:
          print("Error: Invalid task index.")
def MAIN(): # Non-standard function name (should be lowercase)
    mgr=taskMgr() # No space around =
    mgr.addTask("Buy groceries")
    mgr.addTask("Finish homework")
    mgr.viewTasks()
    mgr.complete_task(1)
    mgr.viewTasks()
if __name__=="__main__": # No spaces around ==
    MAIN()
