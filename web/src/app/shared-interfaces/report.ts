export interface Report {
  id?: number | String,
  engineModel: String;
  name: String;
  contactName: String;
  company: String;
  includeFuel: boolean;
  commissioningParts: boolean;
  spareParts: boolean;
  tools: boolean;
  lubeOilChange: boolean;
  plannedServiceA: boolean;
  plannedServiceB: boolean;
  plannedServiceC: boolean;
  topEndOverhaul: boolean;
  bottomEndOverhaul: boolean;
  date?: String;
}

export class ReportTemplate implements Report {
  engineModel: String = '';
  name: String = '';
  contactName: String = '';
  company: String = '';
  includeFuel: boolean = false;
  commissioningParts: boolean = false;
  spareParts: boolean = false;
  tools: boolean = false;
  lubeOilChange: boolean = false;
  plannedServiceA: boolean = false;
  plannedServiceB: boolean = false;
  plannedServiceC: boolean = false;
  topEndOverhaul: boolean = false;
  bottomEndOverhaul: boolean = false;
  date?: String;
}