import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BikedataComponent } from './bikedata.component';

describe('BikedataComponent', () => {
  let component: BikedataComponent;
  let fixture: ComponentFixture<BikedataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BikedataComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BikedataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
