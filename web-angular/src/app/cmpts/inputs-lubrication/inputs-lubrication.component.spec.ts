import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputsLubricationComponent } from './inputs-lubrication.component';

describe('InputsLubricationComponent', () => {
  let component: InputsLubricationComponent;
  let fixture: ComponentFixture<InputsLubricationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputsLubricationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputsLubricationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
