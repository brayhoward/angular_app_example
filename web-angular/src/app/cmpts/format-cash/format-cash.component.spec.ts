import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormatCashComponent } from './format-cash.component';

describe('FormatCashComponent', () => {
  let component: FormatCashComponent;
  let fixture: ComponentFixture<FormatCashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormatCashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormatCashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
