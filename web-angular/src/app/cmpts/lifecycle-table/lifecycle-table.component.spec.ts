import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LifecycleTableComponent } from './lifecycle-table.component';

describe('LifecycleTableComponent', () => {
  let component: LifecycleTableComponent;
  let fixture: ComponentFixture<LifecycleTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LifecycleTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LifecycleTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
