import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-for-provider',
  templateUrl: './details-for-provider.component.html',
  styleUrls: ['./details-for-provider.component.css']
})
export class DetailsForProviderComponent implements OnInit {
  
  parameter:any;
  detailsList:any;

  constructor(private userService: UserService,private activatedroute: ActivatedRoute) { 
    this.activatedroute.queryParams.subscribe(data => {
      this.parameter=data;
  })
  }

  ngOnInit():void {
    console.log(this.parameter.rideId);
      this.userService.detailsForProvider(this.parameter.rideId).subscribe(
        data => {
          this.detailsList=data;
        }
      )
      console.log(this.detailsList);
  }

}
