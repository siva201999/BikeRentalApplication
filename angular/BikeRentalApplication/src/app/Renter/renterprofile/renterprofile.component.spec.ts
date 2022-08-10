import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RenterprofileComponent } from './renterprofile.component';

describe('RenterprofileComponent', () => {
  let component: RenterprofileComponent;
  let fixture: ComponentFixture<RenterprofileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RenterprofileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RenterprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
