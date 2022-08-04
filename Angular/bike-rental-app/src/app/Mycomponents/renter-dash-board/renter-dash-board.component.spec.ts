import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RenterDashBoardComponent } from './renter-dash-board.component';

describe('RenterDashBoardComponent', () => {
  let component: RenterDashBoardComponent;
  let fixture: ComponentFixture<RenterDashBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RenterDashBoardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RenterDashBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
