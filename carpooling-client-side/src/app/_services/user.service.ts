import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';

const API_URL = 'http://localhost:8080/api/test/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient,private token: TokenStorageService) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }

  getAllRides(userName:String): Observable<any> {
    return this.http.get(API_URL+ 'showAllRides/'+userName); 
  }
  addRide(ride): Observable<any>{
    let name:string=this.token.getUser().username;
    return this.http.post(API_URL+'offerRide',{
      source: ride.source,
      destination:ride.destination,
      rideDate:ride.rideDate,
      vacency:ride.vacency,
      costPerSeat:ride.costPerSeat,
      carName:ride.carName,
      offerBy:name,
    }, httpOptions);
  }
  searchByDate(date:String){
    let name:string=this.token.getUser().username;
    return this.http.get(API_URL+'findRideByDate/'+date+"/"+name);
  }
  seeOfferedRides(username:String){
    return this.http.get(API_URL+'seeOfferedRides/'+username);
  }
  bookARide(ride:any){
    let name:string=this.token.getUser().username;
    return this.http.post(API_URL+'bookARide',{
      rideId:ride.id,
      userName:name,
      role:'passenger',
    },httpOptions);
  }
  bookmyRide(id:number){
    let name:string=this.token.getUser().username;
    return this.http.post(API_URL+'bookARide',{
      rideId:id,
      userName:name,
      role:'passenger',
    },httpOptions);
  }

  myRides(){
    let userName:string=this.token.getUser().username;
    return this.http.get(API_URL+"myrides/"+userName);
  }

  deletePassenger(id:number,rideId:number,userName:string){
    return this.http.get(API_URL+"deletepassenger/"+id+"/"+userName+"/"+rideId);
  }
  deleteDriverAndPassenger(id:number){
    let userName:string=this.token.getUser().username;
    console.log(userName);
    return this.http.get(API_URL+"deletedriverandpassenger/"+id+"/"+userName);
  }

  rideDetails(id:number,providerName:string){
    return this.http.get(API_URL+"ridedetails/"+id+"/"+providerName);
  }
  detailsForProvider(id:number){
    return this.http.get(API_URL+"detailsforprovider/"+id);
  }
}