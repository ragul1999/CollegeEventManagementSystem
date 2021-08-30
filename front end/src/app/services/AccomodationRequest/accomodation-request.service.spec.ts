import { TestBed } from '@angular/core/testing';

import { AccomodationRequestService } from './accomodation-request.service';

describe('AccomodationRequestService', () => {
  let service: AccomodationRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AccomodationRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
