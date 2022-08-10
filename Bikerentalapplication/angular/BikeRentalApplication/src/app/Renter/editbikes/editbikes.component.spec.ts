import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditbikesComponent } from './editbikes.component';

describe('EditbikesComponent', () => {
  let component: EditbikesComponent;
  let fixture: ComponentFixture<EditbikesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditbikesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditbikesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
