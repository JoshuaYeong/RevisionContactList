import { Component, OnInit } from '@angular/core';
import { Contact } from '../models';
import { ContactService } from '../services/contact.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  _list: Contact[] = []
  contactId!: string

  constructor(private contSvc: ContactService) { }

  ngOnInit(): void {
    this.contSvc.getAllContacts().subscribe(v => this._list = v)
  }

  async deleteContact(idx: number) {
    this.contactId = this._list.at(idx)?.id!
    await this.contSvc.deleteContact(this.contactId).toPromise()
    console.log('>>>>>DELETED: ', this.contactId)
    this.ngOnInit
    console.log(">>>>>ngOnInit is called")
  }

}
