import { Component, Input } from '@angular/core';
import { animate, state, style, transition, trigger } from '@angular/animations';
import { uniqBy } from 'lodash';

@Component({
  selector: 'filtering-search-input',
  templateUrl: './filtering-search-input.component.html',
  animations: [
    trigger('searchExpand', [
      state('collapsed', style({ height: '0px', minHeight: '0', visibility: 'hidden' })),
      state('expanded', style({ maxHeight: '20em', visibility: 'visible'})),
      transition('expanded <=> collapsed', animate('325ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})
export class FilteringSearchInputComponent {
  results: any[] = [];
  suggestions: Suggestion[] = [];
  searchTerm: String = '';

  @Input()
  searchPool: any[] = [];

  @Input()
  searchResultsCallback: (arg) => void;


  onChange({ target: { value = '' } }) {
    this.filterAndUpdate(value);
  }

  onBlur() {
    this.suggestions = [];
  }

  filterAndUpdate = (searchTerm) => {
    const { matchedItems, suggestions } = filter(this.searchPool, searchTerm);

    this.suggestions = suggestions;
    this.results = matchedItems;
    this.searchTerm = searchTerm;

    this.searchResultsCallback(this.results);
  }

  hasResults = () => this.suggestions.length > 0;

  onSelectSuggestion({ id }) {
    console.log('suggestion id selected', 'LOGGED BELLOW');
    console.log(id);
  }

  dirty = () => !!this.searchTerm

  jsonify = node => JSON.stringify(node);

  log = (node, name = 'node') => {
    console.log(name, 'LOGGED BELLOW');
    console.log(node);
  }
}

interface Suggestion {
  id: number | String,
  value: String
};
interface Results {
  // table rows
  matchedItems: any[],
  suggestions: Suggestion[]
}

function filter(items: any[], searchTerm): Results {
  let preCleanedSuggestions: Suggestion[] = [];

  const matchedItems: any[] = (
    // Filter each item/row for the search term;
    items.filter(item => {
      const id = item.id;
      const keys = Object.keys(item);
      const rowString = keys.reduce((accu, key) => `${accu} ${item[key]}`, '');
      const hasMatch = matches(rowString, searchTerm);

      if (hasMatch) {
        // Add to suggestions array
        const newSuggestions =
        keys.map(key => (
          { id, value: item[key] }
        ))
        .filter(item => (
          // Filter out id's and/or any value thats not a string
          (typeof item.value === 'string') && matches(item.value, searchTerm)
        ));

        preCleanedSuggestions = [...preCleanedSuggestions, ...newSuggestions]
      }

      return hasMatch;
    })
  );

  // console.log('suggestions', 'LOGGED BELLOW');
  // console.log(JSON.stringify(preCleanedSuggestions));
  const suggestions = uniqBy(preCleanedSuggestions, 'value');

  return { matchedItems, suggestions };
}

const matches = (value, searchTerm) => {
  if (typeof value !== 'string') return false;

  const formatedVal = value.toLowerCase();
  const formatedTerm = searchTerm.toLowerCase();

  return (formatedVal.indexOf(formatedTerm) > -1);
}