import { Project } from './Project';

export class Task{
    
    parent :ParentTask = new ParentTask;
    taskId: number;
    task:string;
    startDate:Date;
    endDate:Date;
    priority:number;
    project :Project=new Project;
    status:string;
    constructor(){
        this.taskId=0;
        this.parent.parentTask='';
        this.task='';
       
        this.priority=0;
        this.project.projectId=0;
        this.status='';
    }
}

class ParentTask{
    parentId:number;
    parentTask :string;
}