import { TestBed } from '@angular/core/testing';

import { HostelserviceService } from './hostelservice.service';

describe('HostelserviceService', () => {
  let service: HostelserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HostelserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
