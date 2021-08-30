import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminViewFestComponent } from './admin-view-fest.component';

describe('AdminViewFestComponent', () => {
  let component: AdminViewFestComponent;
  let fixture: ComponentFixture<AdminViewFestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminViewFestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminViewFestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
