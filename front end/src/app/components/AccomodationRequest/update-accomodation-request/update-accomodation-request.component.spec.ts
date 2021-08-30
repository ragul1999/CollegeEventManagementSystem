import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAccomodationRequestComponent } from './update-accomodation-request.component';

describe('UpdateAccomodationRequestComponent', () => {
  let component: UpdateAccomodationRequestComponent;
  let fixture: ComponentFixture<UpdateAccomodationRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateAccomodationRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateAccomodationRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
