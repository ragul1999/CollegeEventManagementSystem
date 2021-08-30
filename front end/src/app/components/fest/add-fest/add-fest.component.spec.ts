import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFestComponent } from './add-fest.component';

describe('AddFestComponent', () => {
  let component: AddFestComponent;
  let fixture: ComponentFixture<AddFestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
