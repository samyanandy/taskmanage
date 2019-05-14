import { Component, OnInit } from '@angular/core';
import {Task} from '../../Task'
import {ParentTask} from '../../ParentTask'
import {TaskService} from '../../task.service';
import {FormGroup} from '@angular/forms'
import {Router} from '@angular/router';
import { Project } from '../../Project';
import { User } from '../../User';
import { ModalContentComponent } from '../modal-content/modal-content.component';
import { ModalProjectComponent } from '../modal-project/modal-project.component';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
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
  projects : Project[];
  users : User[];
  userModal :boolean;
  selectedUser : number;
  selectedProject :number;
  user:string;
  project:string;
  isParent:boolean;
  parentTsk:ParentTask;
  constructor(private _taskService : TaskService,private _router : Router,public modalService: NgbModal) {
    
   }

  ngOnInit() {
    
    this.task= this._taskService.getTask();
    this.task.startDate= new Date();
    this.task.startDate.setDate(this.task.startDate.getDate());
    this.task.endDate= new Date();
    this.task.endDate.setDate(this.task.endDate.getDate() + 1);
    this.parentTsk = this._taskService.getParentTask();
    this.isParent=false;

    
    this._taskService.getAllParentTask().subscribe((res) => {
      this.parentTasks=res;
      // console.log(this.parentTasks);
    },(error) => {
      console.log(error);
    });
    this.userModal=false;
    this._taskService.getAllUser().subscribe((res) => {
      this.users = res;
    },(error) => {
      console.log(error);
    });
    this._taskService.getAllProject().subscribe((p) => {
      this.projects=p;
      // console.log(this.projects)
     });
  }

  
  addTask(){
    // console.log(this.task);
    
    if(this.isParent){
      this.parentTsk.parentTask=this.task.task;
      
         this._taskService.addParentTask(this.parentTsk).subscribe((res) => {
        //  console.log(res);
        },(error) => {
          console.log(error);
        
        })
    }

    

       this._taskService.addTask(this.task).subscribe((res) => {
        //  console.log(res);
         this._taskService.findUser(this.selectedUser).subscribe((user) => {
          if(user['taskId']==0){
            user['taskId'] = res['taskId']
          }
          else{
            user['userId'] = 0;
            user['taskId'] = res['taskId']
          }
          
          this._taskService.addUser(user).subscribe((res) => {
          });
         });
      this._router.navigate(['viewTask'])
    },(error) => {
      console.log(error);
     
    })

  }
  resetData(){
    this.taskForm.reset();
  }

  openUserModal() {
    const modalRef = this.modalService.open(ModalContentComponent);
    modalRef.componentInstance.user = this.users;

    modalRef.componentInstance.passEntry.subscribe((receivedEntry) => {
      this.selectedUser=receivedEntry;
      this._taskService.findUser(this.selectedUser).subscribe((res) => {
        this.user=res.fname+" "+res.lname;
        this.userModal=true;
       },(error) => {
         console.log(error);
       });
      });
    
   
  }

  openProjectModal(){
    const modalRef = this.modalService.open(ModalProjectComponent);
    modalRef.componentInstance.project = this.projects;

    modalRef.componentInstance.passEntry.subscribe((receivedEntry) => {
      this.selectedProject=receivedEntry;
      this._taskService.findProject(this.selectedProject).subscribe((res) => {
        this.task.project=res;
      // this.task.project.project=res.project;
        this.userModal=true;
       },(error) => {
         console.log(error);
       });
      });
    
  }
}
