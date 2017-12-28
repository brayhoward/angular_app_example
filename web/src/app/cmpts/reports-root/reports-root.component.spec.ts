import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportsRootComponent } from './reports-root.component';

describe('ReportsRootComponent', () => {
  let component: ReportsRootComponent;
  let fixture: ComponentFixture<ReportsRootComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReportsRootComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReportsRootComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
