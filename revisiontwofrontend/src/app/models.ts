export interface Contact {
  id: string
  name: string
  email: string
  mobile: string
}

export interface Contacts {
  contactsArray: Contact[]
}

export interface Response {
  code: number
  message?: any
  data?: any
}
