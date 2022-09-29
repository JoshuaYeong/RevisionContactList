import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom, lastValueFrom, Observable } from "rxjs";
import { Contact } from "../models";

// Heroku URL
// const serverURL = "https://revision-two.herokuapp.com/contact"

@Injectable()
export class ContactService {

  deleteQuery!: string

  constructor(private http: HttpClient) { }

  addToDatabase(contacts: Contact[]): Promise<Response> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json')

    return firstValueFrom(
      this.http.post<Response>('/contact', contacts, { headers })
    )
  }

  getAllContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>('/contact/retrieve')
  }

  deleteContact(contactId: string) {
    this.deleteQuery = ('contact/delete/' + contactId)
    console.log('>>>>>DELETE QUERY: ', this.deleteQuery)
    return this.http.delete(this.deleteQuery)
  }

}
