import { Injectable, EventEmitter } from '@angular/core';

@Injectable()
export class ModalService {
  public selectedUserChange = new EventEmitter()
}