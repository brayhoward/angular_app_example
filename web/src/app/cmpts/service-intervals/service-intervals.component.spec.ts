import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceIntervalsComponent } from './service-intervals.component';

describe('ServiceIntervalsComponent', () => {
  let component: ServiceIntervalsComponent;
  let fixture: ComponentFixture<ServiceIntervalsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceIntervalsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceIntervalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
