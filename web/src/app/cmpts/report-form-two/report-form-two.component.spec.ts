import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportFormTwoComponent } from './report-form-two.component';

describe('ReportFormTwoComponent', () => {
  let component: ReportFormTwoComponent;
  let fixture: ComponentFixture<ReportFormTwoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportFormTwoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportFormTwoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
