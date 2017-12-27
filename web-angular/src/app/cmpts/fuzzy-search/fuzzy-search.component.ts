import { style } from '@angular/animations';
import { Component } from '@angular/core';

@Component({
  selector: 'fuzzy-search',
  template: `
    <style>
      input {
        border-radius: 5px;
      }
      .wrapper {
        max-width: 6em;
      }
    </style>

    <div class="wrapper">
      <input
        type="text"
        name="searchTerm"
        [(ngModel)]="searchTerm"
      >

      <ul class="list-ui">
        <li class="list-ui__item" *ngFor = "let item of items | lowercase | filter:searchTerm">
          {{searchTerm.name}}
        </li>
      </ul>
    </div>
  `,
  styleUrls: ['./fuzzy-search.component.scss']
})

export class FuzzySearchComponent{
  items: any[] = [{ name: "jay williams" }, { name: "tim williams" }, { name: "james williams" }, { name: "cindy williams" }, {name: "sam williams"}];
}
