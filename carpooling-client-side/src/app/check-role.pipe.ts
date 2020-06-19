import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'checkRole'
})
export class CheckRolePipe implements PipeTransform {

  transform(myRole: string, role: string): boolean {
    if(myRole.indexOf(role)>-1)
    return true;
    return false;
  }

}
