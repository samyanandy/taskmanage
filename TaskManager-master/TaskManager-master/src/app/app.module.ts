import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTaskComponent } from './components/add-task/add-task.component';
import { ViewTaskComponent } from './components/view-task/view-task.component';
import { HeaderComponent } from './components/header/header.component';
import {TaskService} from './task.service';
import {HttpModule} from '@angular/http';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule ,ReactiveFormsModule} from '@angular/forms';
import {TaskFilter} from './task-filter';
import {UserFilter} from './user-filter';
import { AddUserComponent } from './components/add-user/add-user.component';
import { AddProjectComponent } from './components/add-project/add-project.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { ModalContentComponent } from './components/modal-content/modal-content.component';
import { ModalProjectComponent } from './components/modal-project/modal-project.component';


@NgModule({
  declarations: [
    AppComponent,
    AddTaskComponent,
    ViewTaskComponent,
    HeaderComponent,
    TaskFilter,
    UserFilter,
    AddUserComponent,
    AddProjectComponent,
    ModalContentComponent,
    ModalProjectComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
  
  ],
  providers: [
    TaskService,

  ],
  bootstrap: [AppComponent],
  entryComponents: [ ModalContentComponent,ModalProjectComponent ]

})
export class AppModule { }
