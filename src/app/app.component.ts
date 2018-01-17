import { Component, SimpleChanges, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor( private router: Router ) {}

  handleRouteChanged = ({ detail: { value: route_array } }) => {
    if (!route_array) return;

    // Convert [ 'dash', 'sub' ] => '/dash/sub'
    const path = route_array.reduce((acc, val ) => `${acc}/${val}`, '');

    // Manually trigger navigation when route changed event fired from header-nav > px-app-nav cmpt.
    this.router.navigateByUrl(path)
  }
}
