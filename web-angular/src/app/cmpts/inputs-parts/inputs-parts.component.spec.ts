import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputsPartsComponent } from './inputs-parts.component';

describe('InputsPartsComponent', () => {
  let component: InputsPartsComponent;
  let fixture: ComponentFixture<InputsPartsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputsPartsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputsPartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
