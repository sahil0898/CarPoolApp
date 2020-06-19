import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-ride-details',
  templateUrl: './ride-details.component.html',
  styleUrls: ['./ride-details.component.css']
})
export class RideDetailsComponent implements OnInit {

  isLoggedIn:boolean=false;
  rideDetails:any;
  message:any;
  parameter:any;
  rideId:number;
  offerBy:string;
  ride:any;
  isBooked:boolean;
  isSuccessfull:boolean=false;

  constructor(private userService: UserService,private token:TokenStorageService, 
    private activatedroute: ActivatedRoute) { 
      this.activatedroute.queryParams.subscribe(data => {
        this.parameter=data;
    })
    this.rideId=this.parameter.rideId;
    this.offerBy=this.parameter.offerBy;
    //this.ride=this.parameter.ride;
    this.isBooked=this.parameter.isBooked;
  }

  ngOnInit(){
    if(this.token.getToken()){
      this.isLoggedIn=true;
      this.userService.rideDetails(this.rideId,this.offerBy).subscribe(
        data=>{
          this.rideDetails=data;
        }
      );

    }
    else{
      this.message="Unthorised Access Login to continue"
    } 
  }
  bookARide(){
    this.userService.bookmyRide(this.rideId).subscribe(
      data =>{
      this.isSuccessfull=true;
    },
    err =>{
      this.message="Unable to book";
    }
  );
  }

}
