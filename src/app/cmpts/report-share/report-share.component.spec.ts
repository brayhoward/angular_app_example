import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportShareComponent } from './report-share.component';

describe('ReportShareComponent', () => {
  let component: ReportShareComponent;
  let fixture: ComponentFixture<ReportShareComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportShareComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportShareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
