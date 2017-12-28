import { Component } from '@angular/core';

// Because Angular routing is not great
// Any route with sub-routes needs to have it's very own router-outlet.
// Hence this component @here
@Component({
  selector: 'reports-root',
  template: `
    <router-outlet></router-outlet>
  `
})
export class ReportsRootComponent {}
