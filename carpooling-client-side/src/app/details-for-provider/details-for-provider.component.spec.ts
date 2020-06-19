import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsForProviderComponent } from './details-for-provider.component';

describe('DetailsForProviderComponent', () => {
  let component: DetailsForProviderComponent;
  let fixture: ComponentFixture<DetailsForProviderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsForProviderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsForProviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
