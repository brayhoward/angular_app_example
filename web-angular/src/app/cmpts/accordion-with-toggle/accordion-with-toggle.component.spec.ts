import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccordionWithToggleComponent } from './accordion-with-toggle.component';

describe('AccordionWithToggleComponent', () => {
  let component: AccordionWithToggleComponent;
  let fixture: ComponentFixture<AccordionWithToggleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccordionWithToggleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccordionWithToggleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
