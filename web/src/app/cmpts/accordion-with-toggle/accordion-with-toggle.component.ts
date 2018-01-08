import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'accordion-with-toggle',
  templateUrl: './accordion-with-toggle.component.html',
  styleUrls: ['./accordion-with-toggle.component.scss']
})
export class AccordionWithToggleComponent implements OnInit {
  add: String = "px-utl:add";
  remove: String = "px-utl:remove";
  icon: String = this.add;
  hasToggleSwitch: boolean = false;

  @Input() headerValue: String
  @Input() toggleSwitchCallback: (event: MouseEvent) => void = e => console.log('Pass a cb function to toggleSwitchCallback attr on the <accordion-with-toggle /> cmpt to tap into this event', e);
  @Input() expanded: boolean = false;
  @Input() checked: boolean;


  ngOnInit() {
    const checked = this.checked;
    this.hasToggleSwitch = !!this.toggleSwitchCallback;

    // Defaulted checked to equal true.
    this.checked = (checked === undefined) ? true : checked
  }

  toggleExpanded() {
    this.expanded = !this.expanded;
    const { add, remove, expanded } = this;

    // Toggle the open/close icon
    this.icon = expanded ? remove : add;

    return expanded
  }
}
