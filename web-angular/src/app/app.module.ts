import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';

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
    AccordionWithToggleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ]
})

export class AppModule { }
