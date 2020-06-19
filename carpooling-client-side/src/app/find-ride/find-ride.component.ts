import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-find-ride',
  templateUrl: './find-ride.component.html',
  styleUrls: ['./find-ride.component.css']
})
export class FindRideComponent implements OnInit {

  isLoggedIn:boolean;false;
  isDateSearched:boolean=false;
  listOfRides:any;
  message="";
  journeyDate:string="12-06-2020";
  isSuccesfull:boolean=false;
  source:string="";
  destination:string="";
  isBooked:boolean=false;

  constructor(private userService: UserService,private token:TokenStorageService) { }

  ngOnInit(): void {
    if(this.token.getToken()){
      this.isLoggedIn=true;
    }
    else{
      this.message="Unthorised Access Login to continue"
    }
  }
  searchByDate(){
    console.log("searchByDate");
    this.userService.searchByDate(this.journeyDate).subscribe(
      data => {
        this.listOfRides=data;
        this.isSuccesfull=true;
      },
    )
      this.isDateSearched=true;
  }
  bookARide(ride:any){
    this.userService.bookARide(ride).subscribe(
      data =>{
        this.isBooked=true;
      },
      err =>{
        this.message="Unable to book";
      }
    );
  }

}
