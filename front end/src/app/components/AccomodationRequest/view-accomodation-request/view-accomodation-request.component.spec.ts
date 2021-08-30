import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAccomodationRequestComponent } from './view-accomodation-request.component';

describe('ViewAccomodationRequestComponent', () => {
  let component: ViewAccomodationRequestComponent;
  let fixture: ComponentFixture<ViewAccomodationRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAccomodationRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAccomodationRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
