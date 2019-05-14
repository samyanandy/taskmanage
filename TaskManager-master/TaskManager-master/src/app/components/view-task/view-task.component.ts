import { Component, OnInit } from '@angular/core';
import {TaskService} from '../../task.service';
import {Task} from '../../Task';
import {Project} from '../../Project';
import {Router} from '@angular/router';
import { ModalProjectComponent } from '../modal-project/modal-project.component';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit {

  public tasks: Task[];
  projects : Project[];
  selectedProject :number;
  userModal :boolean;
  selectProj : string;
  constructor(private _taskService : TaskService ,private _router : Router,public modalService: NgbModal) { }

  ngOnInit() {
    this._taskService.getAllTask().subscribe((tsks) => {
      this.tasks=tsks;
      },(error) => {
      console.log(error);
    })
    this._taskService.getAllProject().subscribe((p) => {
      this.projects=p;
      // console.log(this.projects)
     });
  }

  editTask(task){
    this._taskService.setTask(task);
    this._router.navigate(['addTask'])
  }

 endTask (task){
  let self =this;
  this._taskService.deleteTask(task.taskId).subscribe((data) => {
      task.status=1;
   })
    
  }

  openProjectModal(){
    const modalRef = this.modalService.open(ModalProjectComponent);
    modalRef.componentInstance.project = this.projects;

    modalRef.componentInstance.passEntry.subscribe((receivedEntry) => {
      this.selectedProject=receivedEntry;
      this._taskService.findProject(this.selectedProject).subscribe((res) => {
        this.selectProj=res.project;
        // console.log(this.selectProj)
      // this.task.project.project=res.project;
        this.userModal=true;
        this.findByProjectId();
       },(error) => {
         console.log(error);
       });
      });
      

  }

  orderByPriority(){
    this._taskService.getAllTaskOrderByPriority().subscribe((p) => {
      this.tasks=p;
     
     });
  }
  orderByStartDate(){
    this._taskService.getAllTaskOrderByStartDate().subscribe((p) => {
      this.tasks=p;
     
     });
  }

  orderByEndDate(){
    this._taskService.getAllTaskOrderByEndDate().subscribe((p) => {
      this.tasks=p;
         });
  }
  orderByCompleted(){
    this._taskService.getAllTaskOrderByStatus().subscribe((p) => {
      this.tasks=p;
     
     });
  }

  findByProjectId(){
    this._taskService.findByProjectId(this.selectedProject).subscribe((t)=>{
   this.tasks=t;
 })
  }

}
