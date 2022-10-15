import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Login } from '../login';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-chngpswd',
  templateUrl: './chngpswd.component.html',
  styleUrls: ['./chngpswd.component.css']
})
export class ChngpswdComponent implements OnInit {
  loginRef = new FormGroup({
    emailid:new FormControl(),
    password:new FormControl(),
    typeOfUser:new FormControl()
  });
  msg:string=""

  constructor(public ls:LoginService) { }

  ngOnInit(): void {
  }
  forgotPassword() {
    let login = this.loginRef.value;
    this.ls.forgotPassword(login).subscribe({
      next:(result:any)=>this.msg=result,
      error:(error:any)=>console.log(error),
      complete:()=>console.log("completed")
    })
  }

}
