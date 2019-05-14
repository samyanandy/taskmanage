import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal-project',
  templateUrl: './modal-project.component.html'
})
export class ModalProjectComponent implements OnInit {
  @Input() public project;
  @Output() passEntry: EventEmitter<any> = new EventEmitter();
  public selectedProject;

  constructor(
    public activeModal: NgbActiveModal
  ) { }

  ngOnInit() {
    console.log(this.project);
  }

  passBack() {
    this.passEntry.emit(this.selectedProject);
    this.activeModal.dismiss('Cross click')
  }
}