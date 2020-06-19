import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import {OfferRideComponent} from './offer-ride/offer-ride.component';
import { FindRideComponent } from './find-ride/find-ride.component';
import { MyRidesComponent } from './my-rides/my-rides.component';
import { RideDetailsComponent } from './ride-details/ride-details.component';
import { DetailsForProviderComponent } from './details-for-provider/details-for-provider.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'myrides', component: MyRidesComponent},
  { path: 'offerride',component:OfferRideComponent},
  { path: 'findride',component:FindRideComponent},
  { path: 'ridedetails',component:RideDetailsComponent},
  { path: 'passengerdetails', component:DetailsForProviderComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }