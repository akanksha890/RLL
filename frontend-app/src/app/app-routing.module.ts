import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { AdminProductRetrieveComponent } from './admin-product-retrieve/admin-product-retrieve.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { ViewuserComponent } from './viewuser/viewuser.component';
import { ChngpswdComponent } from './chngpswd/chngpswd.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"adminHome",component:AdmindashboardComponent,children:[
    {path:"addProduct",component:AddProductComponent},
    {path:"findAllProduct",component:AdminProductRetrieveComponent},
  {path:"viewusers",component:ViewuserComponent},
  {path:"chngpswd",component:ChngpswdComponent}
  ]},
  
  {path:"userHome",component:UserdashboardComponent},

  {path:"signUp",component:SignupComponent},
  {path:"",redirectTo:"login",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
