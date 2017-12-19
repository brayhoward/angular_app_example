import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'accordion-with-toggle',
  templateUrl: './accordion-with-toggle.component.html',
  styleUrls: ['./accordion-with-toggle.component.scss']
})
export class AccordionWithToggleComponent implements OnInit {
  private add: String = "px-utl:add";
  private remove: String = "px-utl:remove";
  private icon: String = this.add;
  private hasToggleSwitch: boolean = false;

  @Input() headerValue: String
  @Input() toggleSwitchCallback: (event: MouseEvent) => void
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
