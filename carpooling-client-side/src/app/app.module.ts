import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { ProfileComponent } from './profile/profile.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
//import { ShowRidesComponent } from './show-rides/show-rides.component';
import { OfferRideComponent } from './offer-ride/offer-ride.component';
import { FindRideComponent } from './find-ride/find-ride.component';
import { FilterRidesPipe } from './filter-rides.pipe';
import { MyRidesComponent } from './my-rides/my-rides.component';
import { CheckRolePipe } from './check-role.pipe';
import { RideDetailsComponent } from './ride-details/ride-details.component';
import { DetailsForProviderComponent } from './details-for-provider/details-for-provider.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    BoardAdminComponent,
    BoardUserComponent,
    BoardModeratorComponent,
    ProfileComponent,
    //ShowRidesComponent,
    OfferRideComponent,
    FindRideComponent,
    FilterRidesPipe,
    MyRidesComponent,
    CheckRolePipe,
    RideDetailsComponent,
    DetailsForProviderComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }