import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-my-rides',
  templateUrl: './my-rides.component.html',
  styleUrls: ['./my-rides.component.css']
})
export class MyRidesComponent implements OnInit {

  myRidesList:any;
  isDeleteSuccessfull:boolean=false;


  constructor(private userService: UserService,private token:TokenStorageService) { }

  ngOnInit(): void {
      let userName=this.token.getUser().userName;
      this.userService.myRides().subscribe(
        data => {
          this.myRidesList=data;
        },
      )
  }
  deletePassenger(id:number,rideId:number){
    //console.log("hi...");
    let userName=this.token.getUser().userName;
    this.userService.deletePassenger(id,rideId,userName).subscribe(
      data => {
        this.myRidesList=data;
        this.isDeleteSuccessfull=true;
      },
    )
  }
  deleteDriverAndPassenger(id:number){
    this.userService.deleteDriverAndPassenger(id).subscribe(
      data => {
        this.myRidesList=data;
        this.isDeleteSuccessfull=true;
      }
    )
  }

}
