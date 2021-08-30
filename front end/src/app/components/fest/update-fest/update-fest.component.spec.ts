import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFestComponent } from './update-fest.component';

describe('UpdateFestComponent', () => {
  let component: UpdateFestComponent;
  let fixture: ComponentFixture<UpdateFestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateFestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateFestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
