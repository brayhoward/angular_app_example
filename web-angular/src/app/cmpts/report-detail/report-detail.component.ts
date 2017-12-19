import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'report-detail',
  templateUrl: './report-detail.component.html',
  styleUrls: ['./report-detail.component.scss']
})
export class ReportDetailComponent implements OnInit {
  private showLubrication: boolean = true;
  private showFuel: boolean = true;
  private showLabor: boolean = true;

  ngOnInit() {
  }

  private toggleLubrication = (event) => {
    // this.showLubrication = event.detail.value;
    this.toggleProperty('showLubrication')(event)
  }

  private toggleFuel = (event) => {
    this.toggleProperty('showFuel')(event)
  }

  private toggleLabor = (event) => {
    this.toggleProperty('showLabor')(event)
  }

  private toggleProperty = (prop) => (event) => {
    this[prop] = event.detail.value;
    //TODO: remove console.log
    console.log(prop + ':', this[prop])
  }
}
