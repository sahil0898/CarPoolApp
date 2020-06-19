import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_services/token-storage.service';
import { tokenName } from '@angular/compiler';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'app-offer-ride',
  templateUrl: './offer-ride.component.html',
  styleUrls: ['./offer-ride.component.css']
})
export class OfferRideComponent implements OnInit {

  isLoggedin:boolean=false;
  isSuccessful:boolean=false;
  message:string="Enter Ride Details";
  form:any={};
  errorMessage:string;
  

  constructor(private userService:UserService,private token:TokenStorageService) { }

  ngOnInit(): void {
    if(this.token.getToken()){
      this.isLoggedin=true;
    }
    else{
      this.message="Unthorised Access Login to continue"
    }
  }
  
  onSubmit():any{
    this.userService.addRide(this.form).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        //this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        //this.isSignUpFailed = true;
      }
    );
  }

} 
