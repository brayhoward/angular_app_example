import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputsFuelComponent } from './inputs-fuel.component';

describe('InputsFuelComponent', () => {
  let component: InputsFuelComponent;
  let fixture: ComponentFixture<InputsFuelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputsFuelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputsFuelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
