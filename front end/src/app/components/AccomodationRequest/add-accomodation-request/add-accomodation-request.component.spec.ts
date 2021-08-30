import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAccomodationRequestComponent } from './add-accomodation-request.component';

describe('AddAccomodationRequestComponent', () => {
  let component: AddAccomodationRequestComponent;
  let fixture: ComponentFixture<AddAccomodationRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAccomodationRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAccomodationRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
