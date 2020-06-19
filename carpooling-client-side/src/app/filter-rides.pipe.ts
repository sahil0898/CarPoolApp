import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterRides'
})
export class FilterRidesPipe implements PipeTransform {

  transform(source: string, destination:string,inputsource:string ,inputdestination:string): unknown {
    if(inputsource== '' && inputdestination==''){
      return true;
    }
    else if (source.toLowerCase().indexOf(inputsource.toLowerCase())>-1 && inputdestination==''){
      return true;
    }
    else if (destination.toLowerCase().indexOf(inputdestination.toLowerCase())>-1 && inputsource==''){
      return true;
    }
    else if (source.toLowerCase().indexOf(inputsource.toLowerCase())>-1 && 
            destination.toLowerCase().indexOf(inputdestination.toLowerCase())>-1){
      return true;
    }
    else{
      return null;
    }
  }

}
