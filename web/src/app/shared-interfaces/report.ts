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
