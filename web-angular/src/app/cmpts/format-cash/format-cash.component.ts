import { Component, Input } from '@angular/core';

@Component({
  selector: 'format-cash',
  template: `
    <!-- If block -->
    <div *ngIf="money; else moneyNull">
      {{ money | currency}}
    </div>

    <!-- Else block -->
    <ng-template #moneyNull>$-</ng-template>
  `
})
export class FormatCashComponent {
  @Input() money: number | null;
}
