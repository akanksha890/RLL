import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseURL:string ="http://localhost:9090/login";
  constructor(public http:HttpClient) { }

  signIn(login:any):Observable<string> {
    return this.http.post(this.baseURL+"/signIn",login,{responseType:"text"});
  }

  findAllUsers():Observable<Login[]> {
    return this.http.get<Login[]>(this.baseURL+"/findAllUsers");
  }

  deleteUserByemailid(emailid:string):Observable<string> {
    return this.http.delete(this.baseURL+"/deleteusers/"+emailid,{responseType:"text"});
  }

  updateusers(emailid:any):Observable<string> {
    return this.http.patch(this.baseURL+"/updateUsers",emailid,{responseType:"text"});
  }
  
  signUp(login:any):Observable<string> {
    return this.http.post(this.baseURL+"/signUp",login,{responseType:"text"});
  }

  findAllUserBytypeOfUser(typeOfUser:string):Observable<string> {
    return this.http.get(this.baseURL+"/findAllProduct/"+typeOfUser,{responseType:"text"});
  }

  forgotPassword(login:any):Observable<string> {
    return this.http.post(this.baseURL+"/forgotPass",login,{responseType:"text"});
  }

}
