import { Injectable } from '@angular/core';
import {Http, Response, Headers,RequestOptions} from '@angular/http'
import {HttpClient} from '@angular/common/http';
import {map, catchError} from 'rxjs/operators';
import {Task} from './Task';
import {ParentTask} from './ParentTask';
import { HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from './User';
import { Project } from './Project';


@Injectable({
  providedIn: 'root'
})
export class TaskService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

  private baseUrl : string ="http://localhost:9090"
  private task = new Task();
  private user = new User();
  private project = new Project();
  constructor(private _http :Http,private http:HttpClient) { }

  getAllTask() : Observable<Task[]>{
    return this.http.get(this.baseUrl+"/task/getAllTask")
    .pipe(map((response: any) => response));
  }

  addTask(task : Task){
    return this.http.post(this.baseUrl+ '/task/addTask' , task, this.httpOptions)
    .pipe(map((res : Response)=> res));
  }

  deleteTask(id :number){
    return this.http.get(this.baseUrl+"/task/deleteTask/" + id)
    .pipe(map((res : Response)=> res));
  }


  getAllParentTask(): Observable<ParentTask[]>{
    return this.http.get(this.baseUrl+"/task/getAllParentTask")
    .pipe(map((response: any) => response));
  }

// USER

addUser(user : User){
  return this.http.post(this.baseUrl+ '/user/addUser' , user, this.httpOptions)
  .pipe(map((res : Response)=> res));
}

getAllUser() : Observable<User[]>{
  return this.http.get(this.baseUrl+"/user/getAllUser")
  .pipe(map((response: any) => response));
}

deleteUser(user: User){
  return this.http.post(this.baseUrl+ '/user/deleteUser' , user, this.httpOptions)
  .pipe(map((res : Response)=> res));
}

findUser(id : number){
  return this.http.get(this.baseUrl+"/user/findUser/"+id)
  .pipe(map((response: any) => response));
}

getAllUserOrderByFname() : Observable<User[]>{
  return this.http.get(this.baseUrl+"/user/getAllUserOrderByFname")
  .pipe(map((response: any) => response));
}

getAllUserOrderByLname() : Observable<User[]>{
  return this.http.get(this.baseUrl+"/user/getAllUserOrderByLname")
  .pipe(map((response: any) => response));
}

getAllUserOrderByEmployeeId() : Observable<User[]>{
  return this.http.get(this.baseUrl+"/user/getAllUserOrderByEmployeeId")
  .pipe(map((response: any) => response));
}

//PROJECT

addProject(project : Project){
  return this.http.post(this.baseUrl+ '/user/addProject' , project, this.httpOptions)
  .pipe(map((res : Response)=> res));
}

getAllProject() : Observable<Project[]>{
  return this.http.get(this.baseUrl+"/user/getAllProject")
  .pipe(map((response: any) => response));
}

deleteProject(project: Project){
  return this.http.post(this.baseUrl+ '/user/deleteProject' , project, this.httpOptions)
  .pipe(map((res : Response)=> res));
}

getAllProjectOrderByPriority() : Observable<Project[]>{
  return this.http.get(this.baseUrl+"/user/getAllProjectOrderByPriority")
  .pipe(map((response: any) => response));
}

getAllProjectOrderByStartDate() : Observable<Project[]>{
  return this.http.get(this.baseUrl+"/user/getAllProjectOrderByStartDate")
  .pipe(map((response: any) => response));
}

getAllProjectOrderByEndDate() : Observable<Project[]>{
  return this.http.get(this.baseUrl+"/user/getAllProjectOrderByEndDate")
  .pipe(map((response: any) => response));
}
// getter setters

  setTask(task :Task){
    this.task=task;
  }
  getTask(){
    return this.task;
  }

  setUser(user : User){
    this.user=user;
  }
  getUser(){
    return this.user;
  }

  setProject(project : Project){
    this.project=project;
  }
  getproject(){
    return this.project;
  }
}
