import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { environment } from '../environments/environment';

import { AngularFireModule } from '@angular/fire/compat';
import { AngularFireAuthModule } from '@angular/fire/compat/auth';
import { AngularFireStorageModule } from '@angular/fire/compat/storage';
import { AngularFirestoreModule } from '@angular/fire/compat/firestore';
import { AngularFireDatabaseModule } from '@angular/fire/compat/database';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { NewGameComponent } from './pages/new-game/new-game.component';
import { ReactiveFormsModule } from '@angular/forms';
import {ApiService} from './shared/services/api.service';
import { ListGameComponent } from './pages/list-game/list-game.component';
import { BoardComponent } from './pages/board/board.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { HeaderComponent } from './componets/header/header.component'

import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatListModule } from '@angular/material/list';
import { MatTableModule } from '@angular/material/table'
import { MatCheckboxModule } from '@angular/material/checkbox';

@NgModule({
  declarations: [
    AppComponent,
    NewGameComponent,
    ListGameComponent,
    BoardComponent,
    HomeComponent,
    LoginComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireAuthModule,
    AngularFirestoreModule,
    AngularFireStorageModule,
    AngularFireDatabaseModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatListModule,
    MatTableModule,
    MatCheckboxModule
  ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
