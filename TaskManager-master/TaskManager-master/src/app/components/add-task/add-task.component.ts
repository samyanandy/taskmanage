import { Component, OnInit } from '@angular/core';
import {Task} from '../../Task'
import {ParentTask} from '../../ParentTask'
import {TaskService} from '../../task.service';
import {FormGroup} from '@angular/forms'
import {Router} from '@angular/router';
@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  task : Task;
  parentTasks:ParentTask[];
  taskForm: FormGroup;
  addPrntTsk : boolean;
  constructor(private _taskService : TaskService,private _router : Router) { }

  ngOnInit() {
    
    this.task= this._taskService.getTask();
    console.log(this.parentTasks);
    this._taskService.getAllParentTask().subscribe((res) => {
      this.parentTasks=res;
    },(error) => {
      console.log(error);
    })
  }

  addTask(){
       this._taskService.addTask(this.task).subscribe((res) => {
      this._router.navigate(['viewTask'])
    },(error) => {
      console.log(error);
     
    })

  }
  resetData(){
    this.taskForm.reset();
  }
}
