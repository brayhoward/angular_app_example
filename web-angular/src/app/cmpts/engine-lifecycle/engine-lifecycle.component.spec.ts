import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EngineLifecycleComponent } from './engine-lifecycle.component';

describe('EngineLifecycleComponent', () => {
  let component: EngineLifecycleComponent;
  let fixture: ComponentFixture<EngineLifecycleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EngineLifecycleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EngineLifecycleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
