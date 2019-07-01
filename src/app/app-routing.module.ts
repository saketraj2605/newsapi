import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
const routes: Routes = [
  { path: '', 
    component: LoginComponent 
  },
  { path: 'admin', 
    component: AdminComponent 
  },
  { path: 'login', 
    component: LoginComponent 
  },
  { path: 'home', 
  component: HomeComponent 
},
  { path: 'signup', 
  component: SignupComponent 
},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
