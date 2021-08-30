import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserModule } from '@angular/platform-browser';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import { MatMenuModule } from '@angular/material/menu';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminComponent } from './admin/admin.component';
import { CollegeComponent } from './components/college/college.component';
import { CollegeServiceService } from './services/college-service.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ParticipantComponent } from './components/participant/participant.component';
import { ParticipantService } from './services/participant.service';
import { FestServiceService } from './services/fest-service.service';
import { AddFestComponent } from './components/fest/add-fest/add-fest.component';
import { AddcollegeComponent } from './components/addcollege/addcollege.component';
import { HostelserviceService } from './services/hostelservice.service';
import { AddhostelComponent } from './components/addhostel/addhostel.component';
import { AddAccomodationRequestComponent } from './components/AccomodationRequest/add-accomodation-request/add-accomodation-request.component';
import { FormsModule } from '@angular/forms';
import { ViewEventComponent } from './components/event/view-event/view-event.component';
import { EventServiceService } from './services/event-service.service';
import { AddEventComponent } from './components/event/add-event/add-event.component';
import { AccomodationRequestService } from './services/AccomodationRequest/accomodation-request.service';
import { ViewAccomodationRequestComponent } from './components/AccomodationRequest/view-accomodation-request/view-accomodation-request.component';
import { SignupComponent } from './components/credential/signup/signup.component';
import { LoginComponent } from './components/credential/login/login.component';
import { AddAccomodationComponent } from './components/Accomodation/addAccomodation/add-accomodation/add-accomodation.component';
import { ViewAccomodationComponent } from './components/Accomodation/viewAccomodation/view-accomodation/view-accomodation.component';
import { AccomodationService } from './services/Accomodation/accomodation.service';
import { UpdateAccomodationRequestComponent } from './components/AccomodationRequest/update-accomodation-request/update-accomodation-request.component';
import { UpdateFestComponent } from './components/fest/update-fest/update-fest.component';
import { AdminViewFestComponent } from './components/fest/admin-view-fest/admin-view-fest.component';
import { StudentComponent } from './student/student.component';
import { EventParticipantsService } from './services/EventParticipant/event-participants.service';
import { EventHistoryComponent } from './components/EventHistory/event-history/event-history.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    CollegeComponent,
    AdminViewFestComponent,
    AddFestComponent,
    ParticipantComponent,
    AddcollegeComponent,
    AddhostelComponent,
    AddAccomodationRequestComponent,
    ViewEventComponent,
    AddEventComponent,
    ViewAccomodationRequestComponent,
    SignupComponent,
    LoginComponent,
    AddAccomodationComponent,
    ViewAccomodationComponent,
    UpdateAccomodationRequestComponent,
    UpdateFestComponent,
    StudentComponent,
    EventHistoryComponent,
    StudentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatTabsModule,
    MatMenuModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    NgbModule
   
  ],
  providers: [
    CollegeServiceService,
    ParticipantService,
    FestServiceService,
    HostelserviceService,
    EventServiceService,
    AccomodationRequestService,
    AccomodationService,
    EventParticipantsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
