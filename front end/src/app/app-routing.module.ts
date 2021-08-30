import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AddAccomodationComponent } from './components/Accomodation/addAccomodation/add-accomodation/add-accomodation.component';
import { ViewAccomodationComponent } from './components/Accomodation/viewAccomodation/view-accomodation/view-accomodation.component';
import { AddAccomodationRequestComponent } from './components/AccomodationRequest/add-accomodation-request/add-accomodation-request.component';
import { UpdateAccomodationRequestComponent } from './components/AccomodationRequest/update-accomodation-request/update-accomodation-request.component';
import { ViewAccomodationRequestComponent } from './components/AccomodationRequest/view-accomodation-request/view-accomodation-request.component';
import { AddcollegeComponent } from './components/addcollege/addcollege.component';
import { AddhostelComponent } from './components/addhostel/addhostel.component';
import { CollegeComponent } from './components/college/college.component';
import { AddEventComponent } from './components/event/add-event/add-event.component';
import { ViewEventComponent } from './components/event/view-event/view-event.component';
import { LoginComponent } from './components/credential/login/login.component';
import { SignupComponent } from './components/credential/signup/signup.component';
import { ParticipantComponent } from './components/participant/participant.component';
import { UpdateFestComponent } from './components/fest/update-fest/update-fest.component';
import { AddFestComponent } from './components/fest/add-fest/add-fest.component';
import { AdminViewFestComponent } from './components/fest/admin-view-fest/admin-view-fest.component';
import { StudentComponent } from './student/student.component';
import { EventHistoryComponent } from './components/EventHistory/event-history/event-history.component';

const routes: Routes = [
  {path : '', redirectTo : 'login', pathMatch : 'full'},
  {path:"admin", component: AdminComponent},
  {path:"viewcollege", component: CollegeComponent},
  {path:"viewparticipants",component:ParticipantComponent},
  {path:"adminViewFest",component:AdminViewFestComponent},
  {path:"addcollege", component: AddcollegeComponent},
  {path:"addhostel", component : AddhostelComponent},
  {path:"addAccomodationRequest",component: AddAccomodationRequestComponent},
  {path:"viewEvent",component:ViewEventComponent},
  {path:"addEvent",component:AddEventComponent},
  {path:"viewAccomodationRequest",component:ViewAccomodationRequestComponent},
  {path:"login", component : LoginComponent},
  {path:"signup", component : SignupComponent},
  {path:"addAccomodation",component:AddAccomodationComponent},
  {path:"viewAccomodation",component:ViewAccomodationComponent},
  {path:"updateAccomodationRequest",component:UpdateAccomodationRequestComponent},
  {path:"updateFest",component:UpdateFestComponent},
  {path:"addFest",component:AddFestComponent},
  {path:"viewFest",component:AdminViewFestComponent},
  {path:"studentHome",component:StudentComponent},
  {path:"viewHistory",component:EventHistoryComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
