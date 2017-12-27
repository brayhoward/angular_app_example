import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputsLaborComponent } from './inputs-labor.component';

describe('InputsLaborComponent', () => {
  let component: InputsLaborComponent;
  let fixture: ComponentFixture<InputsLaborComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputsLaborComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputsLaborComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
