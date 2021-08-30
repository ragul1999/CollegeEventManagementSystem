import { TestBed } from '@angular/core/testing';
import { FestServiceService } from './fest-service.service';

describe('FestService', () => {
  let service: FestServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FestServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
