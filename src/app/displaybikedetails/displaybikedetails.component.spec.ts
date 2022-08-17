import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplaybikedetailsComponent } from './displaybikedetails.component';

describe('DisplaybikedetailsComponent', () => {
  let component: DisplaybikedetailsComponent;
  let fixture: ComponentFixture<DisplaybikedetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplaybikedetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DisplaybikedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
