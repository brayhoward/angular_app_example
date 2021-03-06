import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

// Material Angular Modules ////////////////////////////////////////////////
import { MatTabsModule } from '@angular/material/tabs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatDialogModule } from '@angular/material/dialog';
import { MatCheckboxModule } from '@angular/material/checkbox';


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
import { ServiceIntervalsComponent } from './cmpts/service-intervals/service-intervals.component';
import { PartsComponent } from './cmpts/parts/parts.component';
import { LifecycleTableComponent } from './cmpts/lifecycle-table/lifecycle-table.component';
import { FormatCashComponent } from './cmpts/format-cash/format-cash.component';
import { ServiceDetailComponent } from './cmpts/service-detail/service-detail.component';
import { FilteringSearchInputComponent } from './cmpts/filtering-search-input/filtering-search-input.component';
import { ReportsRootComponent } from './cmpts/reports-root/reports-root.component';
import { ReportFormComponent } from './cmpts/report-form/report-form.component';
import { ReportFormTwoComponent } from './cmpts/report-form-two/report-form-two.component';
import { ReportShareComponent } from './cmpts/report-share/report-share.component';
import { CallToActionComponent } from './cmpts/call-to-action/call-to-action.component';
import { PartFormComponent } from './cmpts/part-form/part-form.component';

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
    ReportDetailTabsComponent,
    ServiceIntervalsComponent,
    PartsComponent,
    FormatCashComponent,
    LifecycleTableComponent,
    ServiceDetailComponent,
    FilteringSearchInputComponent,
    ReportsRootComponent,
    ReportFormComponent,
    ReportFormTwoComponent,
    ReportShareComponent,
    CallToActionComponent,
    PartFormComponent
  ],
  // Register any components that need to be opened
  // within a Material Angular Dialog HERE in entryComponents
  entryComponents: [
    ServiceDetailComponent,
    ReportFormComponent,
    ReportFormTwoComponent,
    ReportShareComponent,
    PartFormComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MatTabsModule,
    MatTableModule,
    MatDialogModule,
    MatCheckboxModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ]
})

export class AppModule { }
