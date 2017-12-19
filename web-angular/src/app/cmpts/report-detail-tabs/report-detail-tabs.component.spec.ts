import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportDetailTabsComponent } from './report-detail-tabs.component';

describe('ReportDetailTabsComponent', () => {
  let component: ReportDetailTabsComponent;
  let fixture: ComponentFixture<ReportDetailTabsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportDetailTabsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportDetailTabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
