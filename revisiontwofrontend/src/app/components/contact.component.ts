import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Contact } from '../models';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  contactForm!: FormGroup
  contactArray!: FormArray

  constructor(private fb: FormBuilder, private router: Router, private contSvc: ContactService) { }

  ngOnInit(): void {
    this.contactArray = this.fb.array([])
    this.contactForm = this.fb.group({ contacts: this.contactArray })
  }

  addNew() {
    const contactGroup = this.fb.group({
      name: this.fb.control<string>("", [Validators.required, Validators.minLength(3)]),
      email: this.fb.control<string>("", [Validators.required, Validators.email]),
      mobile: this.fb.control<string>("", [Validators.required, Validators.pattern("^[89][0-9]{7}$")])
    })
    this.contactArray.push(contactGroup)
  }

  async processForm() {
    const cont: Contact[] = this.contactForm.value as Contact[]
    console.log('>>>>>CONTACT: ', cont)
    await this.contSvc.addToDatabase(cont)
    this.router.navigate(['/list'])
  }

}
