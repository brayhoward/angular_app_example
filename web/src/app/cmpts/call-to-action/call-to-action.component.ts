import { Component, Input } from '@angular/core';

@Component({
  selector: 'call-to-action',
  template: `
     <button
      [name]="name"
      [type]="type"
      class="btn btn--call-to-action u-m"
      [disabled]="disabled"
      (click)="onClick($event)"
    >
      <!-- Render Children -->
      <ng-content></ng-content>
    </button>
    `
})
export class CallToActionComponent {
  @Input() name?: String = '';
  @Input() type?: String = 'button';
  @Input() disabled?: boolean = false;
  @Input() onClick?: ($event) => void | any = (e) => { console.log('Call to action Clicked!', e) };
}
