
import { Pipe, PipeTransform,Injectable  } from '@angular/core';


@Pipe({
    name: 'searchFilter'
})

@Injectable()
export class UserFilter implements PipeTransform {
    transform(items: any, field : string, srch: string): any[] {
       
        if(!items){
            return[];
        }
        if(!field){
            return items;
        }
        return items.filter((item)=>
        field.split(',').some(key=> item.hasOwnProperty(key) && 
        new  RegExp(srch, 'gi').test(item[key])));
      }
}
