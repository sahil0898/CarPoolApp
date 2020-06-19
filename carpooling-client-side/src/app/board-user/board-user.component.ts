import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {
  content = 'Your Rides';
  isLoggedin:boolean=false;
  currentUser:any;
  offeredRides:any;

  constructor(private userService: UserService,private token:TokenStorageService) {}

  ngOnInit() {
    if(this.token.getToken()){
    this.userService.seeOfferedRides(this.token.getUser().username).subscribe(
      data=>{this.offeredRides=data
      },
      err => {
        this.content = 'Error while fetching' //JSON.parse(err.error).message;
        this.isLoggedin=false;
        //this.token.signOut();
      }
    );
    }
    else{
      this.content="Please Login or signup first";
    }
    /*if(this.token.getToken()){
      this.currentUser=this.token.getUser();
      this.isLoggedin=true;
    } */
    //console.log(this.offeredRides);
    } 
  }
