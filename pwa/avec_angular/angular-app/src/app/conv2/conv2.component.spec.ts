import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Conv2Component } from './conv2.component';

describe('Conv2Component', () => {
  let component: Conv2Component;
  let fixture: ComponentFixture<Conv2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Conv2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Conv2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
