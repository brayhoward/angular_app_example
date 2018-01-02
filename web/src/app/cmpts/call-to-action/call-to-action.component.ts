import { Component, Input, OnInit } from '@angular/core';
import { style } from '@angular/animations';

@Component({
  selector: 'call-to-action',
  template: `
    <button
      [name]="name"
      [type]="type"
      class="btn u-m flex flex--row flex--center flex--middle"
      [ngStyle]="{'font-size': (large ? '1.1em' : 'inherit')}"
      [class.btn--call-to-action]="isPrimary"

      [disabled]="disabled"
      (click)="onClick($event)"
    >
      <!-- Render Children -->
      <ng-content></ng-content>
    </button>
    `
})
export class CallToActionComponent implements OnInit {
  isPrimary: boolean = true;

  @Input()
  secondary: boolean = false;

  @Input()
  name?: String = '';

  @Input()
  type?: String = 'button';

  @Input()
  disabled?: boolean = false;

  @Input()
  large: boolean = false;

  @Input('click')
  onClick?: ($event) => void | any = (e) => { console.log('Call to action Clicked!', e) };

  ngOnInit() {
    this.isPrimary = !(this.secondary);
  }
}
