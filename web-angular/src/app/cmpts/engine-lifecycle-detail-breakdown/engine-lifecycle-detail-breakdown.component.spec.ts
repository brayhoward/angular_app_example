import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EngineLifecycleDetailBreakdownComponent } from './engine-lifecycle-detail-breakdown.component';

describe('EngineLifecycleDetailBreakdownComponent', () => {
  let component: EngineLifecycleDetailBreakdownComponent;
  let fixture: ComponentFixture<EngineLifecycleDetailBreakdownComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EngineLifecycleDetailBreakdownComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EngineLifecycleDetailBreakdownComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
