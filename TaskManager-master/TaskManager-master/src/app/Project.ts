export class Project{
    projectId: number;
    project :string;
    startDate : Date;
    endDate : Date;
    priority : number;
    manager : string;
    constructor(){
        this.projectId=0;
        this.project='';
        this.priority=0;
        this.manager='';    
    }
}
