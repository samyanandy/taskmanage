import { Component, OnInit } from '@angular/core';
import { Project } from '../../Project';
import { User } from '../../User';
import {TaskService} from '../../task.service';
import {Router} from '@angular/router';
import { ModalContentComponent } from '../modal-content/modal-content.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrls: ['./add-project.component.css']
})
export class AddProjectComponent implements OnInit {

  project : Project;
  projects : Project[];
  users : User[];
  dateCheck : boolean;
  selectedUser : number;
  manager : string;
  modalOpened : boolean;
  constructor(private _taskService : TaskService,private _router : Router,public modalService: NgbModal) { }

  ngOnInit() {
    this.project= this._taskService.getproject();
    this.modalOpened=false;
    this.dateCheck = false;
    this._taskService.getAllUser().subscribe((res) => {
      this.users = res;
    },(error) => {
      console.log(error);
    });
    this._taskService.getAllProject().subscribe((p) => {
      this.projects=p;
      console.log(this.projects)
     });
  }

  addProject(){
    console.log(this.project);
    this._taskService.addProject(this.project).subscribe((res) => {
      this._taskService.getAllProject().subscribe((p) => {
        this.projects=p;
        
       });
     
  });
}
editProject(project) {
  console.log(project)
  this._taskService.setProject(project);
  
}
  openModal() {
    const modalRef = this.modalService.open(ModalContentComponent);
    modalRef.componentInstance.user = this.users;

    modalRef.componentInstance.passEntry.subscribe((receivedEntry) => {
      this.selectedUser=receivedEntry;
      this._taskService.findUser(this.selectedUser).subscribe((res) => {
        this.project.manager=res.fname + " " + res.lname;
        this.modalOpened=true;
       },(error) => {
         console.log(error);
       });
      });
    
   
  }
  
  orderByPriority(){
    this._taskService.getAllProjectOrderByPriority().subscribe((p) => {
      this.projects=p;
     
     });
  }
  orderByStartDate(){
    this._taskService.getAllProjectOrderByStartDate().subscribe((p) => {
      this.projects=p;
     
     });
  }

  orderByEndDate(){
    this._taskService.getAllProjectOrderByEndDate().subscribe((p) => {
      this.projects=p;
     
     });
  }
}
