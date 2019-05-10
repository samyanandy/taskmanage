import { Component, OnInit, Input } from '@angular/core';
import {User} from '../../User'
import {TaskService} from '../../task.service';
import {Router} from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';;

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user : User;
  public users: User[];
  userForm : FormGroup;
  submitted = false;
  constructor(private _taskService : TaskService,private _router : Router,private formBuilder: FormBuilder) { }

  ngOnInit() {

    this.user= this._taskService.getUser();
    this.userForm = this.formBuilder.group({
      fname: ['', Validators.required],
      lname: ['', Validators.required],
      employeeId: ['', [Validators.required]]
  });

  

  //getAllUser
  this._taskService.getAllUser().subscribe((res) => {
     this.users=res;
    },(error) => {
      console.log(error);
    })

  }
  get f() { return this.userForm.controls; }

  onSubmit(){
    this.submitted = true;
    if (this.userForm.invalid) {
      return;
  }else{
   
    this.user.fname=this.userForm.value.fname;
    this.user.lname=this.userForm.value.lname;
    this.user.employeeId=this.userForm.value.employeeId;
    console.log(this.user);
    this._taskService.addUser(this.user).subscribe((res) => {
      this._taskService.getAllUser().subscribe((u) => {
        this.users=u;
       });
   
    },(error) => {
      console.log(error);
     
    })
  }
   
  }


  editUser(user){
    console.log(user)
    this._taskService.setTask(user);
    //this._router.navigate(['user'])
    // Update the data on the form
  this.userForm.patchValue({
    fname: user.fname,
    lname: user.lname,
    employeeId: user.employeeId
});
this.user.userId=user.userId;
}

deleteUser(user){
  this._taskService.deleteUser(user).subscribe((res) => {
    this._taskService.getAllUser().subscribe((u) => {
      this.users=u;
     });
 
  });
}


orderByFname(){
  this._taskService.getAllUserOrderByFname().subscribe((u) => {
    this.users=u;
   });
}
orderByLname(){
  this._taskService.getAllUserOrderByLname().subscribe((u) => {
    this.users=u;
   });
}
orderByEmployeeId(){
  this._taskService.getAllUserOrderByEmployeeId().subscribe((u) => {
    this.users=u;
   });
}
}
