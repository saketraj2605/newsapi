import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { SignupService } from './signup.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  languages: any;
  signupStatus: any;
  errorMessage: any;
  successMessage: any;
  signupForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.maxLength(70)]),
    email: new FormControl('',Validators.required),
    password: new FormControl('', [Validators.required, Validators.maxLength(70), Validators.minLength(6)]),
    repeatPassword: new FormControl('', [Validators.required, Validators.maxLength(30), Validators.minLength(6)]),
    language: new FormControl('', Validators.required),
   
  });
  constructor(private signupService: SignupService) { }

  ngOnInit() {
    // this.signupService.getLanguages().subscribe(data => {
    //   this.languages = data;
    // },
    //   error => {
    //     this.errorMessage = "System Error! Contact Admin!";
    //   }
    // )
  }
  signup() {
    if ((this.signupForm.get('repeatPassword').value) == (this.signupForm.get('password').value)) {
      this.signupService.signup(this.signupForm.value)
        .subscribe(data => {
          this.signupStatus = data;
          if (this.signupStatus.status) {
            this.successMessage = "Signup is Successful!";
            this.errorMessage = null;
            this.signupForm.reset();
          } else {
            this.errorMessage = this.signupStatus.error;
            this.successMessage = null;
          }
        },
          error => {
            this.errorMessage = error.error.errorMessage;
          }
        )
    }
    else {
      this.errorMessage = "Password didn't matched, Please try again!";
    }
  }
}
