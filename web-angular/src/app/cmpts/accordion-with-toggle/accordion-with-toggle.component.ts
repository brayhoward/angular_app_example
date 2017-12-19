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
  expanded: boolean = false;

  @Input() headerValue: String
  @Input() toggleSwitchCallback: (event: MouseEvent) => void


  ngOnInit() {
  }

  toggleExpanded() {
    this.expanded = !this.expanded;
    const { add, remove, expanded } = this;

    this.icon = expanded ? remove : add;

    return expanded
  }
}
