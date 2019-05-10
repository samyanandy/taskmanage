export class Task{
    
    parent :ParentTask = new ParentTask;
    
    task:string;
    startDate:string;
    endDate:string;
    priority:number;

    constructor(){
        
        this.parent.parentTask='';
        this.task='';
        this.startDate='';
        this.endDate='';
        this.priority=0;
    }
}

class ParentTask{
    parentId:number;
    parentTask :string;
}