import { Component, SimpleChanges, Input } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(
    private route: ActivatedRoute,
    private location: Location
  ) {
    // Bind the this ref to this cmpt
    this.handleRouteChanged.bind(this);
  }

  ngOnChanges(changes: SimpleChanges) {

    console.log(`selectedRoute changed: ${changes.selectedRoute.currentValue}`);
    // You can also use categoryId.previousValue and
    // categoryId.firstChange for comparing old and new values
  }

  handleRouteChanged(event) {

    console.log('detect header-nav selected-route-changed in app.component')
    console.log(event.detail.value)
  }
}
