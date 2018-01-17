import { Component, Input} from '@angular/core';

@Component({
  selector: 'header-nav',
  templateUrl: './header-nav.component.html',
  styleUrls: ['./header-nav.component.scss']
})
export class HeaderNavComponent {
  @Input() handleRouteChanged: Function;
}
