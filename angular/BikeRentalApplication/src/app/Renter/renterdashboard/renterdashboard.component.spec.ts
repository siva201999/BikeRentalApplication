import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RenterdashboardComponent } from './renterdashboard.component';

describe('RenterdashboardComponent', () => {
  let component: RenterdashboardComponent;
  let fixture: ComponentFixture<RenterdashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RenterdashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RenterdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
