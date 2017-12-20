import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
// Needed form material tabs ////////////////////////////////////////////////
import { MatTabsModule } from '@angular/material/tabs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
/////////////////////////////////////////////////////////////////////////////

// Routes
import { AppRoutingModule } from './app-routing.module';

// Components needed for Module
import { AppComponent } from './app.component';
import { HeaderNavComponent } from './cmpts/header-nav/header-nav.component';
import { DashboardComponent } from './cmpts/dashboard/dashboard.component';
import { ReportsComponent } from './cmpts/reports/reports.component';
import { ReportDetailComponent } from './cmpts/report-detail/report-detail.component';
import { SettingsComponent } from './cmpts/settings/settings.component';
import { EngineLifecycleComponent } from './cmpts/engine-lifecycle/engine-lifecycle.component';
import { InputsEngineComponent } from './cmpts/inputs-engine/inputs-engine.component';
import { AccordionWithToggleComponent } from './cmpts/accordion-with-toggle/accordion-with-toggle.component';
import { InputsPartsComponent } from './cmpts/inputs-parts/inputs-parts.component';
import { InputsFuelComponent } from './cmpts/inputs-fuel/inputs-fuel.component';
import { InputsLubricationComponent } from './cmpts/inputs-lubrication/inputs-lubrication.component';
import { InputsLaborComponent } from './cmpts/inputs-labor/inputs-labor.component';
import { ReportDetailTabsComponent } from './cmpts/report-detail-tabs/report-detail-tabs.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderNavComponent,
    DashboardComponent,
    ReportsComponent,
    ReportDetailComponent,
    SettingsComponent,
    EngineLifecycleComponent,
    InputsEngineComponent,
    AccordionWithToggleComponent,
    InputsPartsComponent,
    InputsFuelComponent,
    InputsLubricationComponent,
    InputsLaborComponent,
    ReportDetailTabsComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatTabsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ]
})

export class AppModule { }
