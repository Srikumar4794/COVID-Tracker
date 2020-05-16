import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {TrackerService} from "../service/tracker.service";
import {StatusModel} from "../model/status.model";
import {error} from "@angular/compiler/src/util";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  title = 'frontend';
  trackingForm: FormGroup;
  results: StatusModel;
  stateFormDisplay: boolean = false;
  errorPresent: boolean = false;

  constructor(private trackerService: TrackerService, private fb: FormBuilder) {
  }

  ngOnInit(){
    this.initTrackingForm();
    this.errorPresent = false;
  }

  initTrackingForm() {
    this.trackingForm = this.fb.group(
      {
        stateId: [],
      }
    );
  }

  displayStateForm() {
    this.errorPresent = false;
    this.stateFormDisplay = true;
  }

  findStateStatus(){
    let stateCode: string = this.trackingForm.value.stateId;
    this.trackerService.getStateStatus(stateCode).subscribe((data) =>
    {
      this.results = data;
      this.errorPresent = false;
      console.log(this.results);
      this.stateFormDisplay = false;
    },
      error => {
        this.errorPresent = true;
      });
  }

  getCountryResults() {
    this.trackerService.getCountryStatus().subscribe(
      (data) => {
        this.errorPresent = false;
        console.log(data);
        this.results = data;
      }
    )
  }
}
