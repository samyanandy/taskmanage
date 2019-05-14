
import { Pipe, PipeTransform,Injectable  } from '@angular/core';


@Pipe({
    name: 'taskFilter'
})

@Injectable()
export class TaskFilter implements PipeTransform {
    transform(items: any, taskSrch: string, prntTaskSrch:string, priorityFrmSrch:number, priorityToSrch:number, dateStSrch:string,dateEdSrch:string): any[] {
        if (items && items.length){
            return items.filter(item =>{
                let isFound=true;
                if (taskSrch && item.task.toLowerCase().indexOf(taskSrch.toLowerCase()) === -1){
                    isFound = isFound && false;
                }
                if (prntTaskSrch && item.parent.parentTask.toLowerCase().indexOf(prntTaskSrch.toLowerCase()) === -1){
                    isFound = isFound && false;
                }
                if (priorityFrmSrch && priorityToSrch && !(item.priority >= priorityFrmSrch  && item.priority <= priorityToSrch)){
                    isFound = isFound && false;
                 
               }
                if (dateEdSrch && dateStSrch && !(item.startDate >= dateStSrch  && item.endDate <= dateEdSrch)){
                     isFound = isFound && false;
                  
                }
                return isFound;
                
           })
        }
        else{
            return items;
        }
        
      }
}
