import { TestBed } from '@angular/core/testing';

import { RenterserviceService } from './renterservice.service';

describe('RenterserviceService', () => {
  let service: RenterserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RenterserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});