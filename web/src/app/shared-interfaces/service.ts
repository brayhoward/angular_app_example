// Data models
export interface Service {
  name: String,
  total: number,
  totalParts: number,
  totalLabor: number,
  parts: Part[],
  labor: Labor[]
}
export interface Part {
  description: String,
  number: String,
  id: number | String
  price: number,
  quantity: number,
  extendedPrice: number
}
export interface Labor {
  description: String,
  price: number,
  id: number | String
}

export default Service;