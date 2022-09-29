import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home.component';
import { ContactComponent } from './components/contact.component';
import { ListComponent } from './components/list.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ContactService } from './services/contact.service';

const appPath: Routes = [
  {path:'', component:HomeComponent},
  {path: 'contact', component:ContactComponent},
  {path: 'list', component:ListComponent},
  { path: '**', redirectTo: '/', pathMatch: 'full' }
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ContactComponent,
    ListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(appPath, { useHash: true}),

  ],
  providers: [ ContactService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
