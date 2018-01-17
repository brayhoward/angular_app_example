import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputsEngineComponent } from './inputs-engine.component';

describe('InputsEngineComponent', () => {
  let component: InputsEngineComponent;
  let fixture: ComponentFixture<InputsEngineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputsEngineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputsEngineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
