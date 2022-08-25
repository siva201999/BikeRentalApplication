import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RentalComponent } from './rentnow.component';

describe('RentnowComponent', () => {
  let component: RentalComponent;
  let fixture: ComponentFixture<RentalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RentalComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RentalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
